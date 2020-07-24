package com.jardim.nutri.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Nutricionista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Nome não pode ser vazio!")
	private String nome;

	@NotEmpty(message = "CRN não pode ser vazio!")
	private String crn;
	
	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	private String password;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	 * "nutricionista", orphanRemoval = true) private List<Paciente> pacientes = new
	 * ArrayList<>();
	 */

	public Nutricionista() {

	}

	public Nutricionista(Integer id, String nome, String crn, String email, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.crn = crn;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	/*
	 * public List<Paciente> getPacientes() { return pacientes; }
	 * 
	 * public void setPacientes(List<Paciente> pacientes) { this.pacientes =
	 * pacientes; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nutricionista other = (Nutricionista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
