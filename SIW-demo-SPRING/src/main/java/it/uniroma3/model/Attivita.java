package it.uniroma3.model;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String dataOra;

	@ManyToOne
	private Centro centro;

	@ManyToMany(mappedBy = "attivita")
	private List<Allievo> allievi;

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public Attivita(String nome, String data) {
		this.nome = nome;
		this.dataOra = data;
		this.allievi = new ArrayList<Allievo>();
	}

	public Attivita() {
		this.allievi = new ArrayList<Allievo>();
	}

	public void setAllievi(List<Allievo> allievi) {
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
		this.allievi.add(allievo);
	}
	
	public void removeAllievo(Allievo allievo) {
		List<Allievo> list = new ArrayList<>();
		for(Allievo a: this.allievi) {
			if(!a.getEmail().equals(allievo.getEmail())) {
				list.add(a);
			}
		}
		this.setAllievi(list);
	}

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
}