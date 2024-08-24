package app.controller;

import app.bean.Student;
import app.factory.StudentServiceFactory;
import app.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	private IStudentService studentService;

	@Override
	public String save(Student student) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.save(student);
	}

	@Override
	public Student findById(Integer id) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.findById(id);
	}

	@Override
	public String deleteById(Integer id) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.deleteById(id);
	}

	@Override
	public String updaateById(Student student) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.updaateById(student);
	}
}
