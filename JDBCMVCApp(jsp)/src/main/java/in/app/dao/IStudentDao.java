package in.app.dao;

import in.app.bean.Student;

public interface IStudentDao {
	String save(Student student);

	Student findById(Integer id);

	String deleteById(Integer id);

	String updaateById(Student student);
}
