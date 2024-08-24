package app.controller;

import app.Model.Student;

public interface IStudentController {
	String saveorUpdate(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);
}
