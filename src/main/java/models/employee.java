package models;

public class employee {
	private String rollnumber;
	private String employeename;
	private String email;
	private String address;
	private int pincode;
	private long phonenumber;
	private int gender;
	private String password;
	
	public String getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employee(String rollnumber, String employeename, String email, String address, int pincode, long phonenumber,
			int gender,String password) {
		super();
		this.rollnumber = rollnumber;
		this.employeename = employeename;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.password = password;

	}
	
	
}
