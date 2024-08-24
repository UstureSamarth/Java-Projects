package app.controller;

import app.bean.Student;

public interface IStudentController {
	String save(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);

	String updaateById(Student student);
}
