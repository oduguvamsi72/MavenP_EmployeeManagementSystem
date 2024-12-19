package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.employeedbconnections;
import models.employee;
import services.employeeservices;

//---------Delete EmployeeServlet----------

@WebServlet("/delete")
public class deleteemployee extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollnumber = req.getParameter("rollnumber");

		employeeservices service = new employeeservices(employeedbconnections.getConnection());
		boolean f = service.deleteemployee(rollnumber);
		if (f) {
			resp.sendRedirect("");
		} else {
			resp.sendRedirect("");
		}
	}
}
