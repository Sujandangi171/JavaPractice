package com.example.j2se.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		char ch;
		Student st;
		int i;
		StudentDao sDao = new StudentDao();

		do {
			System.out.println("-----MENU-----");
			System.out.println("a. Add a new Student");
			System.out.println("b. Get a Student details");
			System.out.println("c. Get all Student details ");
			System.out.println("d. Update all Student details ");
			System.out.println("e. Delete all Student details ");
			System.out.println(" Make Choice!! ");
			ch = sc.next().charAt(0);
			sc.nextLine();
			if (ch == 'a' || ch == 'A') {
				st = getNewStudentDetails();
				i = sDao.save(st);
				if (i == 1) {
					System.out.println("Student saved to the Database ");
				} else {
					System.out.println("Task failed");
				}
			}
			if (ch == 'b' || ch == 'B') {
				System.out.println("Enter the id of the student ");
				int id = sc.nextInt();
				st = sDao.getOne(id);
				System.out.println(st);
			}
			if (ch == 'c' || ch == 'C') {
				List<Student> students = sDao.getAll();
				students.forEach(System.out::println);
			}
			if (ch == 'd' || ch == 'D') {
				st = getUpdatedStudentsDetails();
				i = sDao.update(st);
				if (i == 1) {
					System.out.println("Student updated in the database!");
				} else {
					System.out.println("Update failed!");
				}
			}
			if (ch == 'e' || ch == 'E') {
				System.out.println("Enter the id of the student :");
				int id = sc.nextInt();
				st = sDao.getOne(id);
				System.out.println(st);
				System.out.println("Confirm Delete (y/n) :");
				ch = sc.next().charAt(0);
				if (ch == 'Y' || ch == 'y') {
					i = sDao.delete(id);
					if (i == 0) {
						System.out.println("Delete Failed!");
					} else {
						System.out.println("Student deleted from the database!");
					}
				} else {
					System.out.println("Deletion cancelled");
				}
			}
		} while (ch == 'y' || ch == 'Y');

	}

	private static Student getUpdatedStudentsDetails() {
		Student st = new Student();
		System.out.println("Enter Updated Student's details: ");
		System.out.println("Id: ");
		st.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Name : ");
		st.setName(sc.nextLine());
		System.out.println("Contact : ");
		st.setContact(sc.nextLong());
		System.out.println("Is Active(y/n): ");
		st.setActive((sc.next() == "y") ? true : false);
		return st;
	}

	private static Student getNewStudentDetails() {
		Student st = new Student();
		System.out.println("Enter new Student's details ");
		System.out.println("Name : ");
		st.setName(sc.nextLine());
		System.out.println("Contact : ");
		st.setContact(sc.nextLong());
		System.out.println("Is Active(y/n): ");
		st.setActive((sc.next() == "y") ? true : false);
		return st;
	}

}
