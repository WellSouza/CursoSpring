package br.relembrandoBD.com.etities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_detail")
public class UserDetail {
	
	@Id
	@SequenceGenerator(name = "detail",sequenceName = "seq_detail_id",allocationSize = 1)
	@GeneratedValue(generator = "detail",strategy = GenerationType.SEQUENCE)
	@Column(name="detail_id")
	private int detailId; 
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="idade")
	private int idade;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		
		this.detailId = detailId;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
		user.setUserDetail(this);
	}

	public UserDetail(String sexo, int idade) {
		super();
		//this.detailId = detailId;
		this.sexo = sexo;
		this.idade = idade;
		// this.user = user;
	}

	public UserDetail() {
		super();
	}

	@Override
	public String toString() {
		return "UserDetail [detailId=" + detailId + ", sexo=" + sexo + ", idade=" + idade + "]";
	}
	
	
}
