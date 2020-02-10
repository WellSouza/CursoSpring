package br.relembrandoBD.com.etities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(generator = "user",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "user",sequenceName = "seq_user",allocationSize = 1)
	@Column(name="user_id")
	private int userId;
	
	public Users() {
		super();
	}

	@Column(name="nome")
	private String nome;

	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private UserDetail userDetail;	
		
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Users(int userId, String nome, UserDetail userDetail) {
		super();
		this.userId = userId;
		this.nome = nome;
		this.userDetail = userDetail;
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
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", nome=" + nome + "]";
	}	
}
