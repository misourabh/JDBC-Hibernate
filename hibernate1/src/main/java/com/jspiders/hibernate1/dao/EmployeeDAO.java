package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = 
				Persistence.createEntityManagerFactory("emp");

		manager = factory.createEntityManager();

	     transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {

		try {
			openConnection();

			transaction.begin();

			EmployeeDTO employee1 = new EmployeeDTO();
			employee1.setId(3);
			employee1.setName("REAVTI DHOTRE");
			employee1.setEmail("reavatidhotre79@gmail.com");
			employee1.setContact(7058981415l);
			employee1.setSalary(25000.00);
			employee1.setDesignation("Manager");
			

			manager.persist(employee1);

			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace(); 
			
		} finally {
			closeConnection();
		}
	}
}	