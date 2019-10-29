package com.sciensa.corujaoapi.controller;

/*import java.util.ArrayList;
import java.util.Date;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sciensa.corujaoapi.entity.GenreDocument;
import com.sciensa.corujaoapi.service.GenreService;

@RestController
@RequestMapping(value="/v1/genres")
public class GenreController {
	
	@Autowired
	private GenreService service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GenreDocument>> listGenres() {
		/*
		 * Date today = new Date(); GenreDocument genre = new GenreDocument("1",
		 * "Comédia", today, today);
		 * List<GenreDocument> genres = new ArrayList<>();
		 * genres.add(genre);
		 */
		
		/*
		 * List é apenas uma interface (e não pode instanciar interface)
		 * por isso colocamos ArrayList (é uma implementação do list)
		 */
		List<GenreDocument> genres = service.listGenres();		
	
		return ResponseEntity.status(HttpStatus.OK).body(genres);
	}
}
