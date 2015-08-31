
package br.com.projetoperiodo.model.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Inheritance( strategy = InheritanceType.JOINED )
public class Usuario implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USUARIO_ID")
	private Long id;
	
	@Column(name = "USUARIO_NOME", nullable = false)
	private String nome;
	@Column(name = "USUARIO_LOGIN", nullable = false)
	private String login;
	@Column(name = "USUARIO_SENHA", nullable = false)
	private String senha;
	@Column(name = "USUARIO_EMAIL", nullable = false)
	private String email;

	public String getLogin() {

		return login;
	}

	public String getSenha() {

		return senha;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}
}