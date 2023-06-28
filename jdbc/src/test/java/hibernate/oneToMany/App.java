package hibernate.oneToMany;

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
		lp.setStudent(st);
		lp1.setStudent(st);
		lp2.setStudent(st);
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
		tx.commit();
		session.close();
		sf.close();
		System.out.println("Done");

	}
}
