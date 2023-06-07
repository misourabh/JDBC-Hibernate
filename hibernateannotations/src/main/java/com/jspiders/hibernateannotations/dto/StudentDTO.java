package com.jspiders.hibernateannotations.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Student_information")
public class StudentDTO
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String Student_name;
	@Column(name="percentage")
	private double percent;
	@Column(name="city")
	private String city_name;
	

}