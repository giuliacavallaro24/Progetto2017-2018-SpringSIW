package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import it.uniroma3.model.Centro;
import it.uniroma3.repository.CentroRepository;

@Transactional
@Service
public class CentroService {
	
	@Autowired
	private CentroRepository centroRepository; 
	
	public Centro save(Centro centro) {
		return this.centroRepository.save(centro);
	}

	public List<Centro> findByNome(String nome) {
		return this.centroRepository.findByNome(nome);
	}

	public List<Centro> findAll() {
		return (List<Centro>) this.centroRepository.findAll();
	}
	
	public Centro findById(Long id) {
		Optional<Centro> centri = this.centroRepository.findById(id);
		if (centri.isPresent()) 
			return centri.get();
		else
			return null;
	}

	public boolean alreadyExists(Centro centro) {
		List<Centro> centri = this.centroRepository.findByNomeAndEmail(centro.getNome(), centro.getEmail());
		if (centri.size() > 0)
			return true;
		else 
			return false;
	}	
}
