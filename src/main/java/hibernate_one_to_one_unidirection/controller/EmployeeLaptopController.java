package hibernate_one_to_one_unidirection.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import hibernate_one_to_one_unidirection.dto.Employee;
import hibernate_one_to_one_unidirection.dto.Laptop;
import hibernate_one_to_one_unidirection.service.EmployeeLaptopService;

public class EmployeeLaptopController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeLaptopService employeeLaptopService = new EmployeeLaptopService();

		while (true) {
			System.out.println(
					" 1-insert \n 2-getdislaybyid \n 3-update employee name \n 4-update all employee detail \n 5-update all laptop details \n 6-delete/n7-Display All Details");
			int n = sc.nextInt();
			switch (n) {
			case 1: {
				/**
				 * this is static argument
				 */
				Laptop laptop = new Laptop(206, "ACER", "white", 53553);
				// Employee employee = new Employee(305, "mannan", "mannan@gamil.com", 5535678,
				// laptop);
				Employee employee = new Employee(306, "mannan", "mannan@gamil.com", 5535678);
				employeeLaptopService.saveEmployeeLaptopSrvice(employee, laptop);
			}
				break;

			case 2: {
				System.out.println("enter the employee id");
				int id = sc.nextInt();

				Employee e = employeeLaptopService.getLaptopByEmployeeIdService(id);

				if (e != null) {
					System.out.println(e);
					Laptop l = e.getLaptop();
					if (l != null) {
						System.out.println(l);
					} else {
						System.out.println("foreign key is null");
					}
				} else {
					System.out.println("id does  not found");
				}

			}
				break;

			case 3: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the employee new name");
				String name = sc.next();
				Employee e = employeeLaptopService.getUpdateEmployeeByIdService(id, name);
				if (e != null) {
					System.out.println("successfully updated");
				} else {
					System.out.println("id does not found");
				}

			}
				break;
			case 4: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the employee new name");
				String name = sc.next();
				System.out.println("enter the  new email");
				String email = sc.next();
				System.out.println("enter the new phone number ");
				long phone = sc.nextLong();
				Employee e = employeeLaptopService.getUpdateAllEmployeeDetailByIdService(id, name, email, phone);
				if (e != null) {
					System.out.println("successfully updated");
				} else {
					System.out.println("id does not found");
				}

			}
				break;
			case 5: {
				System.out.println("enter the laptop id");
				int id = sc.nextInt();
				System.out.println("enter the laptop new name");
				String name = sc.next();
				System.out.println("enter the laptop new price");
				double price = sc.nextDouble();
				System.out.println("enter the color");
				String color = sc.next();

				Laptop l = employeeLaptopService.getUpdateLaptopAllDetailByIdService(id, name, price, color);
				if (l != null) {
					System.out.println("successfully updated ");
				} else {
					System.out.println("id does not found");
				}

			}
				break;
			case 6: {
				System.out.println("enter the employee id");
				int id = sc.nextInt();

				/**
				 * below line is correct but we will store reference in any variable because
				 * this object can give null value if this object return null value means id not
				 * found so i will use if else block
				 */
				// employeeLaptopService.getDeleteLaptopEmployeeByIdService(id);

				Employee e = employeeLaptopService.getDeleteLaptopEmployeeByIdService(id);
				if (e != null) {
					System.out.println("successfully deleted");
				} else {
					System.out.println("id not found");
				}

			}
				break;

			case 7: {
				
				List<Employee> emp=employeeLaptopService.getDisplayAllDetailService();
				
				if(!emp.isEmpty()) {
					
					System.out.println("employee Details");
					/**
					 * short cut key foreach loop lane k lye----> forEach enter
					 */
					for (Employee employee : emp) {
						/**
						 * call to String method 
						 */
						System.out.println(emp);
						/**
						 * at here laptop can be null bcoz if foreign key will be null [mean laptop does not assciate from employee]
						 * so i will used if else block yaa if(!laptop.isEmpty()){..}
						 */
						Laptop laptop=employee.getLaptop();
						
						if(laptop!=null) {
							System.out.println(laptop);	
					}  else {
						System.out.println("laptop primay key does not assocaite means foreign key is null");
					}
						
					}
				}

			}
				break;

			default: {
				System.out.println("plz choose valid option");
			}
			}
		}

	}

}
