package com.well.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Student_id")	
	@SequenceGenerator(name="Student_id",sequenceName="seq_student_id",allocationSize=1)
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	public Student() {		
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", email=" + email + "]";
	}


	public Student(String firstname, String lastName, String email) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
	}
	
	
}
