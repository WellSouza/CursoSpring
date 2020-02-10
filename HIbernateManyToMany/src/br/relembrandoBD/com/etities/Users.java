package br.relembrandoBD.com.etities;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user", sequenceName = "seq_user", allocationSize = 1)
	@Column(name = "user_id")
	private int userId;

	public Users() {
		super();
	}

	@Column(name = "nome")
	private String nome;


	
	@OneToOne(mappedBy ="user" ,fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private UserDetail userDetail;

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail; 
	}

	public Users(int userId, String nome) {
		super();
		this.userId = userId;
		this.nome = nome;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Classe> classe;



	public List<Classe> getClasse() {
		return classe;
	}	
	public void setClasse(List<Classe> classe) {
		this.classe = classe;
	}
	// add convenience methods for bi-directional relationship
	public void add(Classe tempClasse) {
		if (classe == null) {
			classe = new ArrayList<>();
		}

		classe.add(tempClasse);

		tempClasse.setUser(this);
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", nome=" + nome + ", userDetail=" + userDetail + "]"; //+ ", classe=" + classe + "]";
	}

}
