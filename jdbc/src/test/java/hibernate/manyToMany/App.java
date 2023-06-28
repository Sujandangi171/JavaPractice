package hibernate.manyToMany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Laptop lp = new Laptop("Dell 3500");
		Laptop lp1 = new Laptop("Lenovo 300");
		Laptop lp2 = new Laptop("HP specter");
		ArrayList<Laptop> laptops = new ArrayList<>();
		laptops.add(lp);
		laptops.add(lp1);
		laptops.add(lp2);
		Student st = new Student("Pragati Adhikari", 987654321, true, laptops);
		Student st1 = new Student("Sujan Dangi", 987654321, true, laptops);
		Student st2 = new Student("Samyam Sharma", 987654321, true, laptops);
		ArrayList<Student> students = new ArrayList<>();
		students.add(st);
		students.add(st1);
		students.add(st2);
		
		lp.setStudents(students);
		lp1.setStudents(students);
		lp2.setStudents(students);
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
//		session.persist(st);
		session.save(lp);
		session.save(lp1);
		session.save(lp2);
		session.save(st);
		session.save(st1);
		session.save(st2);
		tx.commit();
		session.close();
		sf.close();
		System.out.println("Done");

	}
}
