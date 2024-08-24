package app.controller;

import app.Model.Student;
import app.factory.StudentServiceFactory;
import app.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	private IStudentService studentService;

	@Override
	public String saveorUpdate(Student student) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.saveorUpdate(student);
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

}
