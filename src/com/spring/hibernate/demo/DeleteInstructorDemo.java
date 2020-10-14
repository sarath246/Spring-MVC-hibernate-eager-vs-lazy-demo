package com.spring.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {

		
		// create session factory
		
		SessionFactory factory = new Configuration()
					
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		
		try {
			
			
			// start transaction
			session.beginTransaction();
			
			
			// get Instructor by primary key / Id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor found :" + tempInstructor);
			
			
			// delete intructor
			if (tempInstructor != null) {
				
				System.out.println("Deleting the instructor..." + tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Success...");
			
		} finally {

			factory.close();
		}
		
	}

}
