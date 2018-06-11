package it.uniroma3.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Centro {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Centro other = (Centro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String indirizzo;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private long telefono;
	
	@Column(nullable=false)
	private int capienzaMax;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="centro_id")
	private Map<String, Attivita> attivita;     
	
	@ManyToOne
	private Responsabile responsabile;
	
	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}

	// DA ELIMINARE
	public Centro(String nome, String indirizzo, String email, long telefono, int cap) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.capienzaMax = cap;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getCapienzaMax() {
		return capienzaMax;
	}
	public void setCapienzaMax(int capienzaMax) {
		this.capienzaMax = capienzaMax;
	}

	public Map<String, Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(Map<String, Attivita> attivita) {
		this.attivita = attivita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}	
}