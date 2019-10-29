package com.sciensa.corujaoapi.controller;

/*import java.util.ArrayList;
import java.util.Date;*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sciensa.corujaoapi.entity.GenreDocument;
import com.sciensa.corujaoapi.service.GenreService;

@RestController
@RequestMapping(value = "/v1")
public class GenreController {
	
	@Autowired
	private GenreService service;

	@GetMapping(value = "/genres", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GenreDocument>> listGenres() {
		
		try {
			
			List<GenreDocument> genres = service.listGenres();	
			
			return ResponseEntity.status(HttpStatus.OK).body(genres);
			
		} catch(Exception ex) {		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping(value = "/genres", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDocument> addGenre(@RequestBody GenreDocument genreBody) {
		
		if (genreBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			GenreDocument genre = service.addGenre(genreBody);	
			
			return ResponseEntity.status(HttpStatus.OK).body(genre);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(value = "/genres/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<GenreDocument>> getGenre(@PathVariable(value = "id") String id) {
		
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<GenreDocument> genre = service.getGenre(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(genre);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
		
	}
	
	@PutMapping(value = "/genres/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDocument> updateGenre(@PathVariable(value = "id") String id, @RequestBody GenreDocument genreBody) {
		
		if (genreBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			GenreDocument genre = service.updateGenre(id, genreBody);
			
			return ResponseEntity.status(HttpStatus.OK).body(genre);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
