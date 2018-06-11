package it.uniroma3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;

@SpringBootApplication
public class SiwDemoSpringApplication {

	@Autowired
	private AllievoService allievoService; 
	
	public static void main(String[] args) {
		SpringApplication.run(SiwDemoSpringApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Allievo allievo = new Allievo("Carlo", "Verdi", "verdicarlo@me.it", "1234", "12/07/89", "Ginevra");
		allievoService.save(allievo);
		for(Allievo a : allievoService.findByEmail("verdicarlo@me.it")) {
			System.out.println(a.getNome());
		  }
	}
}
