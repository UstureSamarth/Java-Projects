package in.app.dao;

import in.app.bean.Student;
import in.app.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private String status = null;

	@Override
	public String save(Student student) {
		String sqlInsertQuery = "insert into students(`name`,`email`,`city`,`country`) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlInsertQuery);
				if (preparedStatement != null) {
					preparedStatement.setString(1, student.getName());
					preparedStatement.setString(2, student.getEmail());
					preparedStatement.setString(3, student.getCity());
					preparedStatement.setString(4, student.getCountry());

					int rowAffected = preparedStatement.executeUpdate();
					if (rowAffected == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			}

		} catch (SQLException | IOException e) {
			status = "failure";
			throw new RuntimeException(e);

		}
		return status;
	}

	@Override
	public Student findById(Integer id) {
		String sqlSelectQuery = "select id,name,email,city,country from students where id=?";
		Student student = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlSelectQuery);
				if (preparedStatement != null) {
					preparedStatement.setInt(1, id);
					ResultSet resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						student = new Student();
						student.setId(id);
						student.setName(resultSet.getString(2));
						student.setEmail(resultSet.getString(3));
						student.setCity(resultSet.getString(4));
						student.setCountry(resultSet.getString(5));
					}
				}
			}

		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
		return student;
	}

	@Override
	public String deleteById(Integer id) {

		try {
			Student studentRecord = findById(id);
			if (studentRecord != null) {
				connection = JdbcUtil.getJdbcConnection();
				if (connection != null) {
					String sqlDeleteQuery = "delete from students where id=?";
					preparedStatement = connection.prepareStatement(sqlDeleteQuery);
					if (preparedStatement != null) {
						preparedStatement.setInt(1, id);
						Integer rowAffected = preparedStatement.executeUpdate();
						if (rowAffected == 1) {
							status = "success";
						} else {
							status = "failure";
						}
					}
				}
			} else {
				status = "not found";
			}

		} catch (SQLException | IOException e) {
			status = "failure";
			throw new RuntimeException(e);
		}
		return status;
	}

	@Override
	public String updaateById(Student student) {
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				String sqlUpdateQuery = "update students set name=?,email=?,city=?,country=? where id=?";
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
				if (preparedStatement != null) {
					preparedStatement.setString(1, student.getName());
					preparedStatement.setString(2, student.getEmail());
					preparedStatement.setString(3, student.getCity());
					preparedStatement.setString(4, student.getCountry());
					preparedStatement.setInt(5, student.getId());
					Integer rowAffected = preparedStatement.executeUpdate();
					if (rowAffected == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			}

		} catch (SQLException | IOException e) {
			status = "failure";
			throw new RuntimeException(e);
		}
		return status;
	}
}
