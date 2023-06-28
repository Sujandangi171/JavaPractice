package hibernate.oneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="student")


public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="id")
	int id;
	String name;
	long contact;
	boolean active;
	@OneToMany (mappedBy = "student")
	List<Laptop> laptops;

	public Student(String name, long contact, boolean active, List<Laptop> laptops) {
		super();
		this.name = name;
		this.contact = contact;
		this.active = active;
		this.laptops = laptops;
	}
	
	
}