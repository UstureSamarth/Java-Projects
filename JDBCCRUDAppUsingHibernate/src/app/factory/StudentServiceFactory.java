package app.factory;

import app.service.IStudentService;
import app.service.StudentServiceImpl;

public class StudentServiceFactory {
	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
