package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.app.bean.Student;
import in.app.factory.StudentServiceFactory;
import in.app.service.IStudentService;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		RequestDispatcher rd = null;
		String status = null;
		if (requestURI.endsWith("layout")) {
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}
		if (requestURI.endsWith("addform")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setCity(city);
			student.setCountry(country);

			IStudentService service = StudentServiceFactory.getStudentService();
			status = service.save(student);
			if (status.equals("success")) {
				System.out.println("Record added");
				rd = request.getRequestDispatcher("../result.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("insert", "success");
				rd.forward(request, response);
			} else {
				System.out.println("Record not added");
				ServletContext context = getServletContext();
				context.setAttribute("insert", "failure");
				rd = request.getRequestDispatcher("../result.jsp");
				rd.forward(request, response);
			}

		}

		if (requestURI.endsWith("searchform")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			IStudentService service = StudentServiceFactory.getStudentService();
			Student student = service.findById(id);
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);

		}

		if (requestURI.endsWith("deleteform")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			IStudentService service = StudentServiceFactory.getStudentService();
			status = service.deleteById(id);
			if (status.equals("success")) {
				System.out.println("Record  found");
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("delete", "success");
				rd.forward(request, response);
			} else if (status.equals("not found")) {
				System.out.println("Record not found");
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("delete", "not found");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("delete", "failure");
				rd.forward(request, response);
			}

		}
		if (requestURI.endsWith("updateform")) {

			Integer id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setEmail(email);
			student.setCity(city);
			student.setCountry(country);

			IStudentService service = StudentServiceFactory.getStudentService();
			status = service.updaateById(student);
			if (status.equals("success")) {
				System.out.println("Record  found");
				rd = request.getRequestDispatcher("../../success.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../../failure.html");
				rd.forward(request, response);
			}

		}
		if (requestURI.endsWith("editform")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			IStudentService service = StudentServiceFactory.getStudentService();
			Student student = service.findById(id);
			if (student != null) {
				System.out.println("Record  found");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<form method='post' action='./controller/updateform'>");
				out.println("<table align='center' border='1'>");
				out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Email</th>");
				out.println("<th>City</th>");
				out.println("<th>Country</th>");
				out.println("<th></th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + student.getId() + "</td>");
				out.println("<input type='hidden' name='id' value='" + student.getId() + "'/>");
				out.println("<td><input type='text' name='name' value='" + student.getName() + "'/></td>");
				out.println("<td><input type='text' name='email' value='" + student.getEmail() + "'/></td>");
				out.println("<td><input type='text' name='city' value='" + student.getCity() + "'/></td>");
				out.println("<td><input type='text' name='country' value='" + student.getCountry() + "'/></td>");
				out.println("<td><input type='submit' value='Update'/></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");

			} else {
				System.out.println("Record not found");
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}

		}
	}

}
