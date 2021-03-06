package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Course;
import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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
		
			// create the object
			System.out.println("Creating objects...");
			Instructor tempInstructor = new Instructor("mathavan", "revi", "mathavan129@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http//youtube.com","mathu's app");
			
			// associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// start the transaction
			session.beginTransaction();
			
			
			// save the instructor
			System.out.println("Saving instructor..." + tempInstructor);
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Success...");
			
		} finally {

			// add clean up code
			session.close();
			
			factory.close();
		}
		
		
	}

}
