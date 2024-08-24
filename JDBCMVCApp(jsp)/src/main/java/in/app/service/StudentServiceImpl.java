package in.app.service;

import in.app.bean.Student;
import in.app.dao.IStudentDao;
import in.app.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;

	@Override
	public String save(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(student);
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

	@Override
	public String updaateById(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updaateById(student);
	}
}
