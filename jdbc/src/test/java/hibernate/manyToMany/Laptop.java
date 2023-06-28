package hibernate.manyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Laptops")
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String model;
	@ManyToMany //(mappedBy = "laptops")
	List<Student> students;
	
	
	public Laptop(String model) {
		super();
		this.model = model;
	}
	
	
	
}
	
	
	
	
	
	
	


