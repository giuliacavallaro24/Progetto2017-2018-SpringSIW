package it.uniroma3.repository;

import java.util.List;
import it.uniroma3.model.Centro;
import org.springframework.data.repository.CrudRepository;

public interface CentroRepository extends CrudRepository<Centro, Long> {
	
	public List<Centro> findByNome(String nome);

	public List<Centro> findByNomeAndEmail(String nome, String email);

}
