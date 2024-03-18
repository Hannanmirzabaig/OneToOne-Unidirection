package hibernate_one_to_one_unidirection.service;


import java.util.List;

import hibernate_one_to_one_unidirection.dao.EmployeeLaptopDao;
import hibernate_one_to_one_unidirection.dto.Employee;
import hibernate_one_to_one_unidirection.dto.Laptop;

public class EmployeeLaptopService {
	
	EmployeeLaptopDao laptopDao=new EmployeeLaptopDao();
	
	/**
	 * for case 1
	 */
	public Employee saveEmployeeLaptopSrvice(Employee e,Laptop l) {
		//e.setLaptop(l);
		return laptopDao.saveEmployeeLaptopDao(e, l);
	}
	
	/**
	 * for case 2
	 */
	public Employee getLaptopByEmployeeIdService(int id) {
		return laptopDao.getLaptopEmployeeByIdDao(id);
		
	}
	
	/**
	 * for case 3
	 */
	public Employee getUpdateEmployeeByIdService(int id,String name) {
		return laptopDao.getUpdateEmployeeByIdDao(id, name);
	}
	
	/**
	 * for case 4
	 */
	public Employee getUpdateAllEmployeeDetailByIdService(int id,String name,String email,long phone) {
		return laptopDao.getUpdateAllEmployeeDetailByIdDao(id, name, email, phone);
	}
	
	/**
	 * for case 5
	 */
	public Laptop getUpdateLaptopAllDetailByIdService(int id,String name,double price,String color) {
		return laptopDao.getUpdateLaptopAllDetailByIdDao(id, name, price,color);
	}
	
	
	/**
	 * for case 6
	 */
	public  Employee getDeleteLaptopEmployeeByIdService(int id) {
		return laptopDao.getDeleteLaptopEmployeeByIdDao(id);
	}
	
	/**
	 * case 7
	 */
	public List<Employee> getDisplayAllDetailService(){  //agar koi or sa collection import kr rkha h to use pehle dtle krna pdega fir java.util  wala import kre
		return laptopDao.getDisplayAllDetailDao();
	}

}
