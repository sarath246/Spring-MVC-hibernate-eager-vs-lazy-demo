package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Course;
import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;

public class EagerAndLazyDemo {

	public static void main(String[] args) {

		
		// create session factory
		SessionFactory factory = new Configuration()
				
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
		
			// start the transaction
			session.beginTransaction();
		
			// get the instructor from database
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Lovw2Code :instructor :" + tempInstructor);
			
			// get course for the instructor
			System.out.println("Lovw2Code :Courses :" + tempInstructor.getCourses());
						
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\n the session is now closed...");
			
			// get course for the instructor
			System.out.println("\nLovw2Code :Courses :" + tempInstructor.getCourses());
			
			
			System.out.println("Love2Code :Success...");
			
		} finally {

			// add clean up code
			session.close();
			
			factory.close();
		}
		
		
	}

}
