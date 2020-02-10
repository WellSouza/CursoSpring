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
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "course_ent", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "course_ent", sequenceName = "seq_course_id", allocationSize = 1)
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,
					CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH })
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns =@JoinColumn(name="student_id")
			)
	private List<Student> student;

	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public void add(Student std) {
		if(student == null)
			student = new ArrayList<>();
		
		student.add(std);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
}
