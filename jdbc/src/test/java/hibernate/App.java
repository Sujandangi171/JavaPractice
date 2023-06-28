package hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Laptop lp = new Laptop("Dell 3500");
		Student st = new Student ("Pragati Adhikari", 987654321, true , lp);
		Configuration con = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class);
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(st);
		tx.commit();
		session.close();
		sf.close();
		System.out.println("Done");
	}

}
