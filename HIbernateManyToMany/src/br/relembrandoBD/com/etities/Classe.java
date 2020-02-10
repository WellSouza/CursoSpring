package br.relembrandoBD.com.etities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="classe")
public class Classe {

	@Id
	@GeneratedValue(generator = "curso",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "curso",sequenceName = "seq_class",allocationSize = 1)
	@Column(name="id")
	private int id;
	
	@Column(name="curso")
	private String  curso;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private Users user;

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", curso=" + curso + ", user=" + user + "]";
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Classe(int id, String curso, Users user) {
		super();
		this.id = id;
		this.curso = curso;
		this.user = user;
	}

	public Classe() {
		super();
	}
	
	
}
