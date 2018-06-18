package it.uniroma3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@SpringBootApplication
public class SiwDemoSpringApplication {

	@Autowired
	private CentroService centroService; 
	
	@Autowired
	private AttivitaService attivitaService;
	
	@Autowired
	private AllievoService allievoService;
	
	public static void main(String[] args) {
		SpringApplication.run(SiwDemoSpringApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		this.carica();
	}
	
	private void carica() {
		Centro centro = new Centro("ACCADEMIA ESTETICA SPECIALIZZATA S.A.S", "V. Plinio, 7 - Roma", "info@scuola-silvestrini.it", 8009090, 300);
		Allievo allievo = new Allievo("Carlo", "Verdi", "verdicarlo@me.it", "1234", "12/07/89", "Ginevra");
		
		Attivita attivita = new Attivita("Formazione teorica", "lunedi'/9-11 a.m.");
		
		attivita.addAllievo(allievo);
		allievo.addAttivita(attivita);
		centro.addAttivita(attivita);
		
		attivitaService.save(attivita);		
		
		attivita = new Attivita("Qualifica biennale minorenni", "martedi'/10-12 a.m.");
		
		attivita.addAllievo(allievo);
		allievo.addAttivita(attivita);
		centro.addAttivita(attivita);
		
		attivitaService.save(attivita);
		allievoService.save(allievo);
		centroService.save(centro);
		
		for(Allievo a : allievoService.findByEmail("verdicarlo@me.it")) {
			System.out.println(a.getNome());
		}
	}
}
