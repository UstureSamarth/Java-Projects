package app.service;

import app.Model.Student;
import app.dao.IStudentDao;
import app.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;

	@Override
	public String saveorUpdate(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.saveorUpdate(student);
	}

	@Override
	public Student findById(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.findById(id);
	}

	@Override
	public String deleteById(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(id);
	}

}
