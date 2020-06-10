package com.it.eng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.it.eng.dto.IndirizzoDTO2;
import com.it.eng.dto.LibreriaDTO;
import com.it.eng.dto.LibreriaDTO2;
import com.it.eng.service.IndirizzoCRUDService;
import com.it.eng.service.LibreriaCRUDService;

@SpringBootApplication
public class RelationsJpaApplication implements CommandLineRunner{
	
	@Autowired
	private IndirizzoCRUDService indirizzoService;
	
	@Autowired
	private LibreriaCRUDService libreriaService;

	public static void main(String[] args) {
		SpringApplication.run(RelationsJpaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		indirizzoService.add(new IndirizzoDTO2("Piazza Piemonte",3));
		indirizzoService.add(new IndirizzoDTO2("Hoepli",5));
		
		
		System.out.println("Lista di tutti gli indirizzi:");
		List<IndirizzoDTO2> indirizzi = indirizzoService.findAll();
		
		for(int i=0; i<indirizzi.size(); i++) {
			System.out.println(indirizzi.get(i).toString());
		}
		
		libreriaService.add(new LibreriaDTO2(2, "Feltrinelli"));
		libreriaService.add(new LibreriaDTO2(3, "Hoepli"));
		
		System.out.println();
		System.out.println("Lista di tutte le librerie:");
		List<LibreriaDTO> librerie = libreriaService.findAll();
		
		for(int j=0; j<librerie.size(); j++) {
			System.out.println(librerie.get(j).toString());
		}
		
		
		System.out.println();
		System.out.println("Ricerca indirizzo -> " + indirizzoService.findByVia("Piazza Piemonte").toString());
		
		System.out.println();
		System.out.println("Ricerca della libreria -> " + libreriaService.findById(2).toString());
		
		System.out.println();
		System.out.println("Update dell'indirizzo con Corso Buenos Aires.");
		indirizzoService.update("Piazza Piemonte", new IndirizzoDTO2("Corso Buenos Aires", 3));
		
		System.out.println();
		System.out.println("Update della libreria.");
		libreriaService.update(2, new LibreriaDTO2(2, "laFeltrinelli"));
		
		System.out.println();
		System.out.println("Indirizzo modificato -> " + indirizzoService.findByVia("Corso Buenos Aires").toString());
		System.out.println("Libreria modificata -> " + libreriaService.findById(2).toString());
		
		System.out.println("Delete della libreria");
		libreriaService.delete(2);
		
		System.out.println("Delete dell'indirizzo");
		indirizzoService.delete("Corso Buenos Aires");
		
		
	}

}
