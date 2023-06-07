package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.CompDTO;
import com.jspiders.hibernateonetomany.dto.EmpDTO;

public class EmpCompDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	   private static void closeConnection() {
		   if(factory !=null) {
			   factory.close();
		   }
		   if(manager !=null) {
			   manager.close();
		   }
		   if(transaction.isActive()) {
			   transaction.rollback();
		   }
	   }
	   
	   public static void main(String[] args) {
		try {
		   
		openConnection();
		transaction.begin();
		
		EmpDTO employee1=new EmpDTO ();
		employee1.setId(1);
		employee1.setName("suraj");
		employee1.setEmail("surajjadhav10@gmail.com");
		employee1.setDesignation("project manager");
		employee1.setSalary(10000.00);
		manager.persist(employee1);
		
		EmpDTO employee2=new EmpDTO ();
		employee2.setId(2);
		employee2.setName("ravi");
		employee2.setEmail("ravipatil1@gmail.com");
		employee2.setDesignation("manager");
		employee2.setSalary(5656.00);
		manager.persist(employee2);
		
		List<EmpDTO> employees = Arrays.asList(employee1,employee2);
		
		CompDTO company1 = new CompDTO();
		company1.setId(1);
		company1.setName("infosys");
		company1.setCity("mysore");
		company1.setEmployees(employees);
		manager.persist(company1);
		
		transaction.commit();
		}
		   finally { 
			   closeConnection();
		   }
		
		
		
	}

}
