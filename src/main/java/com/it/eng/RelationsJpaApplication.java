package com.it.eng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.it.eng.dto.CategoriaDTO;
import com.it.eng.dto.IndirizzoDTO2;
import com.it.eng.dto.LibreriaDTO;
import com.it.eng.dto.LibreriaDTO2;
import com.it.eng.dto.LibroDTO;
import com.it.eng.dto.LibroDTO2;
import com.it.eng.dto.PossedereDTO;
import com.it.eng.dto.PossedereDTO2;
import com.it.eng.service.CategoriaCRUDService;
import com.it.eng.service.IndirizzoCRUDService;
import com.it.eng.service.LibreriaCRUDService;
import com.it.eng.service.LibroCRUDService;
import com.it.eng.service.PossedereCRUDService;

@SpringBootApplication
public class RelationsJpaApplication implements CommandLineRunner{
	
	@Autowired
	private IndirizzoCRUDService indirizzoService;
	
	@Autowired
	private LibreriaCRUDService libreriaService;

	@Autowired
	private LibroCRUDService libroService;
	
	@Autowired
	private CategoriaCRUDService categoriaService;
	
	@Autowired
	private PossedereCRUDService possedereService;
	
	public static void main(String[] args) {
		SpringApplication.run(RelationsJpaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		// One-to-One
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
		
		System.out.println("Ricerca indirizzo Hoepli-> " + indirizzoService.findByVia("Hoepli").toString());

		System.out.println("Ricerca della libreria -> " + libreriaService.findById(2).toString());
		
		System.out.println("Update dell'indirizzo con Corso Buenos Aires.");
		indirizzoService.update("Hoepli", new IndirizzoDTO2("Corso Buenos Aires", 3));
		
		System.out.println("Update della libreria.");
		libreriaService.update(2, new LibreriaDTO2(2, "laFeltrinelli"));
		
		System.out.println("Indirizzo modificato -> " + indirizzoService.findByVia("Corso Buenos Aires").toString());
		System.out.println("Libreria modificata -> " + libreriaService.findById(2).toString());
		
		System.out.println("Delete della libreria");
		libreriaService.delete(2);
		
		System.out.println("Delete dell'indirizzo");
		indirizzoService.delete("Corso Buenos Aires");
		
		
		// One-to-Many
		categoriaService.add(new CategoriaDTO(2, "Romanzo"));
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2010-05-21");
		libroService.add(new LibroDTO2("Fallen", "Lauren Kate", "Rizzoli", date, 1, 2));
		
		date = new SimpleDateFormat("yyyy-MM-dd").parse("2006-06-01");
		libroService.add(new LibroDTO2("Twilight", "Stephenie Meyer", "Fazi Editore", date, 1, 2));
		
		System.out.println("Lista delle categorie:");
		List<CategoriaDTO> categorie = categoriaService.findAll();
		
		for(int i=0; i<categorie.size(); i++) {
			System.out.println(categorie.get(i).toString());
		}
		
		System.out.println("Lista dei libri:");
		List<LibroDTO> libri = libroService.findAll();
		
		for(int j=0; j<libri.size(); j++) {
			System.out.println(libri.get(j).toString());
		}
		System.out.println("Update categoria 2");
		categoriaService.update(2, new CategoriaDTO(2, "Paranormal romance"));
		
		System.out.println("Update del libro Fallen.");
		libroService.update("Fallen", "Lauren Kate", new LibroDTO2("Fallen", "Lauren Kate", "Rizzoli", date, 2, 2));
		
		System.out.println("Delete dei libri.");
		libroService.delete("Fallen", "Lauren Kate");
		libroService.delete("Twilight", "Stephenie Meyer");
		
		System.out.println("Delete della categoria.");
		categoriaService.delete(2);
		
		
		// Many-To-Many
		System.out.println("Lista.");
		List<PossedereDTO> dto = possedereService.findAll();
		
		for(int k=0; k<dto.size(); k++) {
			System.out.println(dto.get(k).toString());
		}
		
		possedereService.add(new PossedereDTO2(2, "Twilight", "Stephenie Meyer"));
		System.out.println("Nuova relazione aggiunta.");
		
		System.out.println("Relazione 4 -> " + possedereService.findById(2).toString());
		
		possedereService.update(4, new PossedereDTO2(1, "Twilight", "Stephenie Meyer"));
		System.out.println("Relazione 4 modificata.");
		
		possedereService.delete(4);
		System.out.println("Relazione 4 eliminata.");
	}

}
