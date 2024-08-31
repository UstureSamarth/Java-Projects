import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.Model.Student;
import app.controller.IStudentController;
import app.factory.StudentControllerFactory;
import app.util.HiberbateUtil;

public class Main {
	static {
		HiberbateUtil.startUp();
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer option, id;
		String status, name, email, city, country;
		IStudentController studentController = StudentControllerFactory.getStudentController();
		Student student = new Student();

		try {
			while (true) {
				System.out.println("1. Create");
				System.out.println("2. Read");
				System.out.println("3. Update");
				System.out.println("4. Delete");
				System.out.println("5. Exit");
				System.out.print("Enter option:");
				option = Integer.parseInt(br.readLine());

				switch (option) {
				case 1:
					System.out.print("Enter name :");
					name = br.readLine();
					student.setName(name);

					System.out.print("Enter email :");
					email = br.readLine();
					student.setEmail(email);

					System.out.print("Enter city :");
					city = br.readLine();
					student.setCity(city);

					System.out.print("Enter country :");
					country = br.readLine();
					student.setCountry(country);

					status = studentController.saveorUpdate(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Student inserted successfully");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Student inserted failed");
					} else {
						System.out.println("some problem occured");
					}
					break;
				case 2:
					System.out.print("Enter id: ");
					id = Integer.parseInt(br.readLine());
					Student studentInfo = studentController.findById(id);
					if (studentInfo != null) {
						System.out.println(studentInfo);
					} else {
						System.out.println("Record not available for given id " + id);
					}

					break;
				case 3:
					System.out.print("Enter id of student to be updated: ");
					id = Integer.parseInt(br.readLine());
					Student studentRecord = studentController.findById(id);
					if (studentRecord != null) {
						System.out.println("Student old name : " + studentRecord.getName());
						String newName = br.readLine();
						if (newName == null || newName.equals("")) {
							studentRecord.setName(studentRecord.getName());
						} else {
							studentRecord.setName(newName);
						}

						System.out.println("Student old email : " + studentRecord.getEmail());
						String newEmail = br.readLine();
						if (newEmail == null || newEmail.equals("")) {
							studentRecord.setEmail(studentRecord.getEmail());
						} else {
							studentRecord.setEmail(newEmail);
						}

						System.out.println("Student old city : " + studentRecord.getCity());
						String newCity = br.readLine();
						if (newCity == null || newCity.equals("")) {
							studentRecord.setCity(studentRecord.getCity());
						} else {
							studentRecord.setCity(newCity);
						}

						System.out.println("Student old country : " + studentRecord.getCountry());
						String newCountry = br.readLine();
						if (newCountry == null || newCountry.equals("")) {
							studentRecord.setCountry(studentRecord.getCountry());
						} else {
							studentRecord.setCountry(newCountry);
						}

						status = studentController.saveorUpdate(studentRecord);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Student with id " + id + " updated successfully");
						} else {
							System.out.println("some problem occured");
						}
					} else {
						System.out.println("Student with id " + id + " not available");
					}

					break;
				case 4:
					System.out.print("Enter id of student to be deleted: ");
					id = Integer.parseInt(br.readLine());
					status = studentController.deleteById(id);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Student with id " + id + " deleted successfully");
					} else if (status.equalsIgnoreCase("not found")) {
						System.out.println("Student with id " + id + " not available");
					} else {
						System.out.println("some problem occured");
					}
					break;
				case 5:
					System.out.println("Thanks for using application");
					System.exit(0);
					break;
				default:
					System.out.println("Incorrect option");
				}

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}