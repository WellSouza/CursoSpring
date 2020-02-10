package com.well.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {

	@Id()
	@GeneratedValue(generator="seq_instructor_id",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_instructor_id",sequenceName="seq_instructor_id",allocationSize=1)
	@Column(name="id")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	 
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id",nullable=false,referencedColumnName="id")
	private InstructorDetail instructorDetail;

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String firstName) {
		this.firstName = firstName;
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

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Instructor() {
		super();
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_name=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}  
   
	
	
}
