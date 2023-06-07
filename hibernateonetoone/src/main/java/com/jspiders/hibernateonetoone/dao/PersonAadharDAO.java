package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO 
{
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection()
	{
		factory=Persistence.createEntityManagerFactory("aadhar");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();	
	}
	
	private static void closeConnection()
	{
		if(factory !=null) {
			factory.close();
		}
		if (manager !=null) {
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
		
		PersonDTO person=new PersonDTO();
		person.setId(31);
		person.setName("keerti");
		person.setCity("kasegav");
		person.setContact(7058981413l);
		manager.persist(person);
	    

		AadharDTO aadhar=new AadharDTO();
		aadhar.setId(31);
		aadhar.setAadhar_no(4346424254215l);
		aadhar.setDate_of_issue("2-dec-1998");
		manager.persist(aadhar);
		person.setAadhar(aadhar);

		
		
		transaction.commit();
		}
		finally 
		{
    	  closeConnection();
       }
}
}
