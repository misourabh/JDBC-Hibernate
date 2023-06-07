package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmpFindDao{
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("emp");
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
	    		   transaction.begin();
	    	   }
	       }
	       
	       public static void main(String[]args) {
	    	  try {
	    	   openConnection();
	    	   transaction.begin();
	    	   
	    	   EmployeeDTO employee1=manager.find(EmployeeDTO.class, 1);
	    	   System.out.println(employee1);
	    	   transaction.commit();
	    	  }
	    	    finally {  closeConnection();
	    	    }
	    	   
	       }
	
}