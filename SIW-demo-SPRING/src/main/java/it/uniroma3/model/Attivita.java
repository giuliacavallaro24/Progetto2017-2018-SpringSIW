package it.uniroma3.model;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.model.Allievo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Attivita {

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
		Attivita other = (Attivita) obj;
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
	private String dataOra;
	
	@ManyToOne
	private Centro centro;
	
	@ManyToMany(mappedBy="attivita")
	private Map<String, Allievo> allievi;
	
	public Map<String, Allievo> getAllievi() {
		return allievi;
	}
	
	public Attivita(String nome, String data) {
		this.nome = nome;
		this.dataOra = data;
		this.allievi = new HashMap<String,Allievo>();
	}
	
	public Attivita() {
		this.allievi = new HashMap<String,Allievo>();
	}
	public void setAllievi(Map<String, Allievo> allievi) {
		this.allievi = allievi;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void addAllievo(Allievo allievo) {
		this.allievi.put(allievo.getEmail(), allievo);	
	}
}