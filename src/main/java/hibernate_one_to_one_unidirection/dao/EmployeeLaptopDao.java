package hibernate_one_to_one_unidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import hibernate_one_to_one_unidirection.dto.Employee;
import hibernate_one_to_one_unidirection.dto.Laptop;

public class EmployeeLaptopDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	/**
	 * for case 1
	 */
	public Employee saveEmployeeLaptopDao(Employee e, Laptop l) {
		et.begin();
		/**
		 * this setter method will pass laptop id to employee table
		 */
		e.setLaptop(l);
		em.persist(e);
		/**
		 *  bcoz we want that my code not hit data base again again so without persist method
		 * we  save the data without calling persist method for laptop so i used cascde attribute this attribute 
		 * save the data of laptop autmatically inside the data base
		 */
		//em.persist(l);
		et.commit();

		return e;

	}

	/**
	 * for case 2
	 */
	public Employee getLaptopEmployeeByIdDao(int id) {
		return em.find(Employee.class, id);

	}

	/**
	 * for case 3
	 */
	public Employee getUpdateEmployeeByIdDao(int id, String name) {
		Employee e = getLaptopEmployeeByIdDao(id);
		if (e != null) {
			e.setName(name);
			et.begin();
			em.merge(e);
			et.commit();
			return e;
		} else {
			return null;
		}
	}

	/**
	 * for case 4
	 */
	public Employee getUpdateAllEmployeeDetailByIdDao(int id, String name, String email, long phone) {
		Employee e = getLaptopEmployeeByIdDao(id);
		if (e != null) {
			e.setName(name);
			e.setEmail(email);
			e.setPhone(phone);

			et.begin();
			em.merge(e);
			et.commit();
			return e;
		} else {
			return null;
		}
	}
	
	/**
	 *  for case 5
	 */
	public Laptop getUpdateLaptopAllDetailByIdDao(int id,String name,double price,String color) {
		Laptop l=em.find(Laptop.class, id);
		if(l!=null) {
			l.setLaptop_name(name);
			l.setLaptop_price(price);
			l.setLaptop_color(color);
			et.begin();
			em.merge(l);
			et.commit();
			return l;
		}else {
			return null;
		}
		
	}

	/**
	 * for case 6
	 */
	public Employee getDeleteLaptopEmployeeByIdDao(int id) {
		Employee e = getLaptopEmployeeByIdDao(id);

		if (e != null) {
			et.begin();
			em.remove(e);
			et.commit();
			return e;
		} else {
			return null;
		}
	}
	/**
	 * case for 7
	 */
	
//	public List<Employee> getDisplayAllDetailDao(){     //list java.util
//		
//		String query="from Employee";
//		return em.createQuery(query).getResultList();
//		
//	}
	
	public  List<Employee> getDisplayAllDetailDao(){
		
		String query="from Employee";
		List q= em.createQuery(query).getResultList();
		return q;
	}

}





