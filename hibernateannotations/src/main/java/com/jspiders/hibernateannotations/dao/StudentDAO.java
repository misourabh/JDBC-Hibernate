package com.jspiders.hibernateannotations.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateannotations.dto.StudentDTO;

public class StudentDAO 
{
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private static EntityTransaction transaction;
    
    private static void OpenConnection()
    {
    	factory=Persistence.createEntityManagerFactory("annotations");
    	manager=factory.createEntityManager();
    	transaction=manager.getTransaction();
    }
    
      private static void closeConnection() 
      {
    	  if(factory !=null)
    	  {
    		  factory.close();
    	  }
    	  if(manager !=null)
    	  {
    		  manager.close();
    	  }
    	  if(transaction.isActive())
    	  {
    		  transaction.rollback();
    	  }
    	  
      }
      
      public static void main(String []args)
      {
    	  OpenConnection();
    	  transaction.begin();
    	  
    	  StudentDTO student=new StudentDTO();
    	  student.setStudent_name("SAMARTH GOTYA");
    	  student.setPercent(56.21);
    	  student.setCity_name("shelgi solapur");
    	  
    	  manager.persist(student);
    	  transaction.commit();
    	  
    	  closeConnection();
    	  
    	  
      }
}
