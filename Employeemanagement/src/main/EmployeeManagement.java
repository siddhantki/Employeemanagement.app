package main;

import java.util.Scanner;
import dao.Departmentserviceimpl;
import model.Department;

public class EmployeeManagement {

	public static void main(String[] args) {
	int option;
	System.out.println("1.display all department details");
	System.out.println("2.display department details by dept id");
	
	Scanner s1 = new Scanner(System.in);
	System.out.println("Choose the option");
	option = s1.nextInt();
	
	Departmentserviceimpl obj = new Departmentserviceimpl();
	switch(option)
	{
	case 1 :
		System.out.println("Department details are :");
	
		obj.getAllDepartmentss();
		break;
	case 2 :
       obj.getDept(102);
		break;
		default:
			System.out.println("Invalid option");
	}
	}

}
