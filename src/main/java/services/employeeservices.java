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

	public List<employee> getallemployees() {
		List<employee> li = new ArrayList<employee>();
		employee e1=null;
		try {
			String sql="select * from employee";
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
			e1=new employee();
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

}
