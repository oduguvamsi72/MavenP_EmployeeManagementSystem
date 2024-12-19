package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.employeedbconnections;
import models.employee;
import services.employeeservices;

//---------Add EmployeeServlet----------

@WebServlet("/register")
public class employeeservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollnumber = req.getParameter("rollnumber");
		String employeename = req.getParameter("employeename");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		int pincode = Integer.parseInt(req.getParameter("pincode"));
		long phonenumber = Long.parseLong(req.getParameter("phonenumber"));
		int gender = Integer.parseInt(req.getParameter("gender"));
		String password = req.getParameter("password");

		employee emp1 = new employee(rollnumber, employeename, email, address, pincode, phonenumber, gender, password);
		employeeservices service = new employeeservices(employeedbconnections.getConnection());
		
		boolean f = service.addemployees(emp1);
		if (f) {
			resp.sendRedirect("");
		} else {
			resp.sendRedirect("");
		}

	
	}
}
