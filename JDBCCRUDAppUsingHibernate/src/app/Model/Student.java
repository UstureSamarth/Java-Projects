package app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "sname", length = 15)
	private String name;

	@Column(name = "email",length=25)
	private String email;
	
	@Column(name = "city", length = 15)
	private String city;
	
	@Column(name = "country", length = 15)
	private String country;

	static {
		System.out.println("Student class is loading...");
	}

	public Student() {
		System.out.println("Zero parameter constructor used by hibernate...");
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", city=" + city
				+ ", country=" + country + "]";
	}
	

}
