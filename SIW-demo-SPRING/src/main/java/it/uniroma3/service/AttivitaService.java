package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import it.uniroma3.model.Attivita;
import it.uniroma3.repository.AttivitaRepository;

public class AttivitaService {

	
	@Autowired
	private AttivitaRepository attivitaRepository; 
	
	public Attivita save(Attivita attivita) {
		return this.attivitaRepository.save(attivita);
	}

	public List<Attivita> findByNome(String nome) {
		return this.attivitaRepository.findByNome(nome);
	}

	public List<Attivita> findAll() {
		return (List<Attivita>) this.attivitaRepository.findAll();
	}
	
	public Attivita findById(Long id) {
		Optional<Attivita> attivita = this.attivitaRepository.findById(id);
		if (attivita.isPresent()) 
			return attivita.get();
		else
			return null;
	}

	public boolean alreadyExists(Attivita attivita) {
		List<Attivita> attivita = this.attivitaRepository.findByNomeAndEmail(attivita.getNome(), attivita.getEmail());
		if (attivita.size() > 0)
			return true;
		else 
			return false;
	}	
}
