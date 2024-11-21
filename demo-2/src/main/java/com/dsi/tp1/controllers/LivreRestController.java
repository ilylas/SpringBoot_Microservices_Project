package com.dsi.tp1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Livre;
import com.dsi.tp1.service.IServiceLivre;

@RestController
public class LivreRestController {

	@Autowired
	IServiceLivre iServiceLivre;
	
	@GetMapping("/livres")
	public List<Livre> getAll(){
		return iServiceLivre.getAllLivre();
	}
	
	@GetMapping("/livres/{Code}")
	public Livre getOne(@PathVariable("Code") int Code){
		return iServiceLivre.findLivre(Code);
	}

	
	@GetMapping("/LivreByTitre")
	public List<Livre> getOneParam(@RequestParam("Titre") String Titre){
		return iServiceLivre.findByTitre(Titre);
	}
	@PostMapping("/livres")
	public ResponseEntity<Void> addLivre(@RequestBody Livre livre) {
	    if (iServiceLivre.saveLivre(livre)) {
	        System.out.println("Livre ajouté avec succès. Code de statut : " + HttpStatus.CREATED.value());
	        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
	    } else {
	        System.out.println("Erreur lors de l'ajout du livre. Code de statut : " + HttpStatus.INTERNAL_SERVER_ERROR.value());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
	    }
	}

	
	/*
	@PostMapping("/livres")
	public ResponseEntity<Void> addLivre(@RequestBody Livre livre) {
	    if (iServiceLivre.saveLivre(livre)) {
	        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
	    }
	}
	*/

	
	@PutMapping("/livres/{Code}")
	public ResponseEntity<Void> updateLivre(@RequestBody Livre livre, @PathVariable("Code") int Code) {
	    if (iServiceLivre.updateLivre(livre, Code) != null) {
	        System.out.println("Livre mis à jour avec succès. Code de statut : " + HttpStatus.OK.value());
	        return ResponseEntity.status(HttpStatus.OK).build(); // 200 OK
	    } 
	    else {
	        System.out.println("Livre non trouvé. Code de statut : " + HttpStatus.NOT_FOUND.value());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
	    }
	}


	
	@DeleteMapping("/livres/{Code}")
	public ResponseEntity<Void> deleteOne(@PathVariable("Code") int Code){
	    if (iServiceLivre.deleteLivre(Code)) {
	        System.out.println("Livre supprimé avec succès. Code de statut : " + HttpStatus.NO_CONTENT.value());
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } else {
	        return ResponseEntity.notFound().build(); // 404 Not Found
	    }
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
