package it.uniroma3.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Responsabile {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Responsabile other = (Responsabile) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@OneToMany
	@JoinColumn(name = "responsabile_id")
	private Map<String, Centro> centri;

	public Responsabile(String user, String pass, Map<String, Centro> centri) {
		this.username = user;
		this.password = pass;
		this.centri = centri;
	}

	public Map<String, Centro> getCentri() {
		return centri;
	}

	public void setCentri(Map<String, Centro> centri) {
		this.centri = centri;
	}

	public String getUsername() {
		return username;
	}

	public boolean verificaPassword(String user, String pass) {
		// FUNZIONERA' DOPO AVER MODIFICATO OBJECTSERVICE
		// return ( this.username.equals(user) && this.getPassword().equals(pass) );
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}