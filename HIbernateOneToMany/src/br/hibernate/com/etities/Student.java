package br.hibernate.com.etities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "student_ent",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "student_ent",sequenceName = "seq_student",allocationSize =  1)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lasttName;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.REFRESH,
							CascadeType.PERSIST})
	@JoinTable(name="course_student",
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id")				)	
	private List<Course> course;
	
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public String getEmail() {
		return email;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public Student(String firstName, String lasttName, String email) {
		super();
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}
	
	public Student() {		
	}

	public void addCourse(Course tempCourse) {
		if(course == null)
			course = new ArrayList<>();
		
		course.add(tempCourse);
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", email=" + email + "]";
	}
	
}
