package hibernate_one_to_one_unidirection.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="laptopid")
	private Laptop laptop;
	
	public Employee(int id,String name,String email,long pone) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=pone;
	}
	

}
