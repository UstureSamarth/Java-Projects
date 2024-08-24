package app.service;

import app.Model.Student;

public interface IStudentService {
	String saveorUpdate(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);

}
