package app.service;

import app.bean.Student;

public interface IStudentService {
	String save(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);

	String updaateById(Student student);
}
