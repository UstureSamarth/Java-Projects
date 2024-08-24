package app.dao;

import app.Model.Student;

public interface IStudentDao {
	String saveorUpdate(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);

}
