package app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.Model.Student;
import app.util.HiberbateUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String saveorUpdate(Student student) {
		String status = null;
		Transaction transaction = null;
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					session.saveOrUpdate(student);
					flag = true;
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				status = "success";
				transaction.commit();
			} else {
				status = "failure";
				transaction.rollback();
			}
		}
		return status;
	}

	@Override
	public Student findById(Integer id) {

		Session session = null;
		Student student = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				student = session.get(Student.class, id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return student;
	}

	@Override
	public String deleteById(Integer id) {
		String status = null;
		Transaction transaction = null;
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Student student = session.get(Student.class, id);
					if (student != null) {
						session.delete(student);
						flag = true;
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				status = "success";
				transaction.commit();
			} else {
				status = "failure";
				transaction.rollback();
			}
		}
		return status;
	}

}
