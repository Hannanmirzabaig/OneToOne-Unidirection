package hibernate_one_to_one_unidirection.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Laptop {
	@Id
	private int laptop_id;
	private String laptop_name;
	private String laptop_color;
	private double laptop_price;
	

}
