package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.employee;

public class employeeservices {
	private Connection conn;

	public employeeservices(Connection conn) {
		super();
		this.conn = conn;
	}
	

//----------Add Employee--------------- 
	public boolean addemployees(employee emp) {
		boolean f = false;
		try {
			String sql = "insert into employee(rollnumber,employeename,email,address,pincode,phonenumber,gender)values(?,?,?,?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, emp.getRollnumber());
			pmst.setString(2, emp.getEmployeename());
			pmst.setString(3, emp.getEmail());
			pmst.setString(4, emp.getAddress());
			pmst.setInt(5, emp.getPincode());
			pmst.setLong(6, emp.getPhonenumber());
			pmst.setInt(7, emp.getGender());
			int i = pmst.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}
	
//	----------Get All Employee Details------------

	public List<employee> getallemployees() {
		List<employee> li = new ArrayList<employee>();
		employee e1 = null;
		try {
			String sql = "select * from employee";
			PreparedStatement pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				e1 = new employee();
				e1.setRollnumber(rs.getString(1));
				e1.setEmployeename(rs.getString(2));
				e1.setEmail(rs.getString(3));
				e1.setAddress(rs.getString(4));
				e1.setPincode(rs.getInt(5));
				e1.setPhonenumber(rs.getLong(6));
				e1.setGender(rs.getInt(7));
				li.add(e1);
			}
		} catch (Exception e) {

		}
		return li;
	}

//	----------Get Employee Details By Email------------
	public employee getbyemail(String email) {
		employee s = null;
		try {
			String sql = "select * from employee where email=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, "email");

			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				s.setRollnumber(rs.getString(1));
				s.setEmployeename(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setPincode(rs.getInt(5));
				s.setPhonenumber(rs.getLong(6));
				s.setGender(rs.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

//	----------Update Employee Details------------
	public boolean updateemployee(employee em) {
		boolean f = false;
		try {
			String sql = "update employee set rollnumber=?,employeename=?,email=?,adderss=?,pincode=?,phonenumber=?,gender=? where email=?";
			PreparedStatement pmst = conn.prepareStatement(sql);

			pmst.setString(1, em.getRollnumber());
			pmst.setString(2, em.getEmployeename());
			pmst.setString(3, em.getEmail());
			pmst.setString(4, em.getAddress());
			pmst.setInt(5, em.getPincode());
			pmst.setLong(6, em.getPhonenumber());
			pmst.setInt(7, em.getGender());
			pmst.setString(8, em.getEmail());

			int i = pmst.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

//	----------Delete Employee Details------------
	public boolean deleteemployee(String rollnumber) {
		boolean f = false;
		try {
			String sql = "delete from employee where rollnumber=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, "rollnumber");
			int i = pmst.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}
	
//	--------- Employee Login------------
	public boolean loginemployee(String email, String password) {
		boolean f = false;
		try {
			String sql = "select * from employee where email=?,password=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, "email");
			pmst.setString(2, "password");
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}

}
