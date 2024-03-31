package empfinal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import empfinal.Employee;
import empfinal.EmployeeType;

public class EmployeeView implements Serializable{

	private Scanner scanner = new Scanner(System.in);

	List<Employee> employees = new ArrayList<Employee>();
	List<LogIn> login = new ArrayList<LogIn>();
	private Employee temp;
	{
		Employee employee1 = new Employee(1, "nausha", LocalDate.of(1974, 7, 25), EmployeeType.CEO,"WEST BENGAL", "KOLKATA");
		Employee employee2 = new Employee(2, "nausha", LocalDate.of(1974, 7, 25), EmployeeType.CEO,"WEST BENGAL", "KOLKATA");
		Employee employee3 = new Employee(3, "nausha", LocalDate.of(1974, 7, 25), EmployeeType.CEO,"WEST BENGAL", "KOLKATA");
		Employee employee4 = new Employee(4, "nausha", LocalDate.of(1974, 7, 25), EmployeeType.CEO,"WEST BENGAL", "KOLKATA");
		LogIn login1 = new LogIn(1, "priyanka", LoginType.ADMIN);
		LogIn login2 = new LogIn(2, "YASH", LoginType.USER);

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		login.add(login1);
		login.add(login2);
	}
     LogIn currlogin=null;
	public  EmployeeView() {
		System.out.println("EMPLOYEE MANAGEMENT SYSTEM");

		while (true) {
			System.out.println("Log In here");
			String ans = loginCheck(login);
			if (ans.equals("failed")) {
				System.out.println("login failed, try again");
			} else {
				mainOption(ans);
			}
			// mainOption();
			System.out.println("end of option");
		}
	}

	private void mainOption(String ans) {
		// TODO Auto-generated method stub
		// boolean b=loginCheck(login);

		if (ans.equals("USER")) {
			System.out.println("Enter the option from below: ");

			System.out.println("1.Update Employee");
			System.out.println("2.Update Password");
			System.out.println("3.Log out ");
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				employeeUpdate(employees, ans);
				System.out.println("employee update completed");
				return;
			}
			case 2: {
				updatePassword(ans);
				System.out.println("displayed all employee");
				return;
			}
			case 3: {
				/// displayEmployees(employees);
				System.out.println("Logged Out Successfully");
				currlogin=null;
				System.exit(0);
				// new EmployeeView();
			}
			}

		} else {
			System.out.println("Enter the option from below: ");

			System.out.println("1. Add new user Login");
			System.out.println("2. Add employee");
			System.out.println("3. Delete Employee ");
			System.out.println("4. Update Employee");
			System.out.println("5. view  Employee by Id");
			System.out.println("6. view employee by city");
			System.out.println("7. view all employees ");
			System.out.println("8. print all employees in file");
			System.out.println("9. exit");

			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				 addnewuserLogin(login);
				System.out.println("add employee completed");
				mainOption(ans);
				return;
			}
			case 2: {
				addEmployees(employees);
				System.out.println("displayed all employee");
				mainOption(ans);
				return;
			}
			case 3: {
				deleteemployee(employees);
				System.out.println("emp deleted");
				mainOption(ans);
				return;
			}
			case 4: {
				employeeUpdate(employees,ans);
				System.out.println("employee update completed");
				return;
			}
			case 5: {
				employeeFromId(employees,ans);
				System.out.println("displayed all employee");
				return;
			}
			case 6: {
				getEmployeebyCty(employees,ans);
				System.out.println("displayed all employee");
				return;
			}
			case 7: {
				displayEmployees(employees);
				System.out.println("displayed  employee ");
				mainOption(ans);
				return;
			}
			case 8: {
				addemptoFile(employees);
				//System.out.println("displayed  employee ");
				mainOption(ans);
				return;
			}
			case 9: {
				System.out.println("End of Application");
				System.out.println("=======================");
				System.exit(0);
			}
			default:
				System.out.println("Please Select Proper option:");

			}
		}

	}

	private void addemptoFile(List<Employee> employees) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos=new FileOutputStream("employees.txt");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			for(Employee emp :employees) {
				oos.writeObject(emp.toString());
			}
			oos.close();
			fos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	private void updatePassword(String ans) {
		// TODO Auto-generated method stub
		System.out.println("enter new password");
		String password= scanner.next();
		currlogin.setPassword(password);
		mainOption(ans);
	}

	private void getEmployeebyCty(List<Employee> employees2,String ans) {
		// TODO Auto-generated method stub
		System.out.println("Enter employee City");
		String tempcity = scanner.next();
		for (Employee emp : employees) {
			if (emp != null) {
				if (emp.getCity() == tempcity) {
					System.out.println(emp.getName());
				}
			}

		}

		mainOption(ans);
		
	}

	private void addnewuserLogin(List<LogIn> login) {
		// TODO Auto-generated method stub
		boolean ans = true;

		do {
		System.out.println("enter the user Id");
		int userid= scanner.nextInt();
		System.out.println("enter the password");
		String userpassword= scanner.next();
		System.out.println("Enter Employee LogIn type: ");
		String type = scanner.next().toUpperCase();
		LoginType ltype = LoginType.valueOf(type);
		
			LogIn log=new LogIn(userid, userpassword, ltype);
		    login.add(log);
		
		    System.out.println("Do you want to continue.. y/n");

			String input = scanner.next();

			if (!input.equalsIgnoreCase("y")) {

				ans = false;

			}
		} while (ans);

		return;

	
	}

	private String loginCheck(List<LogIn> logins) {
		System.out.println("Enter the user ID:");
		int id = scanner.nextInt();
		System.out.println("Enter the user Password:");
		String password = scanner.next();

		for (LogIn emp : logins) {
			if (emp.getUserId() == id && emp.getPassword().equals(password)) {
				currlogin =emp;
				String e = emp.getLogintype().toString();
				return e;
			}
		}
		return "failed";
	}

	private void addEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
		boolean ans = true;

		do {
			try {
				System.out.println("Enter Employee Id: ");
				int id = scanner.nextInt();
				for (Employee emp : employees) {
					if (emp.getUserid() == id) {
						throw new EmployeeIdalreadyExist("Employee with this id already exists");
					}
				}

				System.out.println("Enter Employee Name: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Enter Employee BirthDay in YYYY-MM-DD: ");

				// scanner.nextLine();

				// int age = scanner.nextInt();
				String age = scanner.next();
				System.out.println("Enter Employee Type: ");
				String type = scanner.next().toUpperCase();
				EmployeeType employeeType = EmployeeType.valueOf(type);
				LocalDate dob1 = LocalDate.parse(age);
				System.out.println("Enter Employee Address: ");
				String address = scanner.next();
				System.out.println("Enter Employee city: ");
				String city = scanner.next();
				Employee employee = new Employee(id, name, dob1, employeeType,address,city);

				employees.add(employee);

				// employee.setAge(age);

				// employees [empCount] = employee;

				// empCount++;

			} catch (EmployeeIdalreadyExist e) {

				System.out.println("Employee Id alreasy Exist Please try with another ID: ");
			}

			// System.out.println("Employee Id alreasy Exist Please try with another ID:");

			System.out.println("Employees Added....");
			System.out.println("Do you want to continue.. y/n");

			String input = scanner.next();

			if (!input.equalsIgnoreCase("y")) {

				ans = false;

			}
		} while (ans);

		return;

	}

	// }
	private void displayEmployees(List<Employee> employees2) {
		// TODO Auto-generated method stub
		if (employees.size() != 0) {
			System.out.println("===========================");
			System.out.println("Id\t:\tName\t:\tAge:\tType");

			System.out.println("===================================");

		}
		for (Employee emp : employees) {
			if (emp != null) {

				System.out.println(emp.getUserid() + " \t\t" + emp.getName() + "\t\t" + emp.getDob() + "\t\t"
						+ emp.getRole().name());

			}

		}

		// System.out.println("==========");
	}

	private void employeeFromId(List<Employee> employees2,String ans) {
		// TODO Auto-generated method stub
		System.out.println("Enter employee ID");
		int tempID = scanner.nextInt();
		for (Employee emp : employees) {
			if (emp != null) {
				if (emp.getUserid() == tempID) {
					System.out.println(emp.getName());
				}
			}

		}

		mainOption(ans);

	}

	private void employeeUpdate(List<Employee> employees, String ans) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("Enter employee ID");
		int tempID = scanner.nextInt();
		for (Employee emp : employees)

		{
			if (emp != null) {
				if (emp.getUserid() == tempID) {
					flag = true;
					System.out.println(emp.getName());
					update(emp);
				}
			}
		}

		if (flag == false)
			System.out.println("No employee found ");

		mainOption(ans);

	}

	private void update(Employee temp) {
		// TODO Auto-generated method stub
		System.out.println("Update\n 1.Name\n2.Age\n3.Designation");
        int ch = scanner.nextInt();

		if(ch == 1)

		{
        System.out.println("Enter new name");
        String tempName = scanner.next();
        temp.setName(tempName);

		if(ch==2){
			System.out.println("Enter new DOB");
			String newAge = scanner.next();
            LocalDate dob =LocalDate.parse(newAge);
			temp.setDob(dob);
		}
		
		
		if(ch ==3)

		{

		System.out.println("Enter new Designation");
        String type = scanner.next().toUpperCase();
       EmployeeType employeeType =EmployeeType.valueOf(type);
       temp.setRole(employeeType);
		
	}
   }
	}

	private void deleteemployee(List<Employee> employees2) {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of number you want to delete");
          int tempID = scanner.nextInt();
          for (Employee emp: employees) {
            if(emp.getUserid()==tempID) {
                employees.remove(tempID);

        	  }

        	  }

	}

	private void getEmployeeOfEmployeeType(List<Employee> employees2) {
		// TODO Auto-generated method stub
		System.out.println("Plz enter the employee type: ");
        String tempname= scanner.next();

		

		for(int i=0; i<4; i++) {
            if(employees.get(i) == null)
              break;
             Employee emp= employees.get(i);
             if(tempname.equals(emp.getRole().name())) {
                System.out.println("Emp Id -->"+emp.getUserid() + "\n"+"Emp Name -->" + emp.getName() +  "\n"+"Emp Age -->" + emp.getDob()+"\n"+"Emp Type-->" + emp.getRole());

		}
		}
		//else {

		//System.out.println("NO EMPLOYEE FOUND");
		
	}

	private void displaybyAge(List<Employee> employees2) {
		// TODO Auto-generated method stub

	}

}
