package empfinal;

import java.time.LocalDate;


public class Employee {
	private int userid;
	private String name;
	private LocalDate dob;
	private EmployeeType role;
	private String address;
	private String city;
	
	
	public Employee(int userid, String name, LocalDate dob, EmployeeType role,String address,String city) {
		super();
		this.userid = userid;
		this.name = name;
		this.dob = dob;
		this.role = role;
		this.address = address;
		this.city = city;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public EmployeeType getRole() {
		return role;
	}
	public void setRole(EmployeeType role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", name=" + name + ", dob=" + dob + ", role=" + role + ", address="
				+ address + ", city=" + city + "]";
	}
	
	
	
}
