package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeUpdateDAO 
{
   private static EntityManagerFactory factory;
   private static EntityManager manager;
   private static EntityTransaction transaction;
   
   private static void openConnection()
   {
	   factory=Persistence.createEntityManagerFactory("emp");
	   manager=factory.createEntityManager();
	   transaction=manager.getTransaction();
	 }
   private static void closeConnection()
   {
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
   
   public static void main(String[]args)
   {
	   try {
	   openConnection();
	   
	   transaction.begin();
	   
	   EmployeeDTO employee= new EmployeeDTO();
	   employee.setId(2);
	   employee.setName("Samarth");
	   employee.setEmail("samarthgote2@.com");
       employee.setContact(12345678910l);
       employee.setDesignation(" engineer");
       employee.setSalary(82350.00);
	   manager.persist(employee);
	   transaction.commit();
	      
	   } finally {
		   closeConnection();
	   }
	   }
   }

