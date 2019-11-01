package com.sciensa.corujaoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.service.MovieService;


@RestController
@RequestMapping(value = "/v1")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listMovies(@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer size, @RequestParam(required = false) String search) {
		
		if (page == null) page = 1;
		if (size == null) size = 10;
		if (search == null) search = "";
		
		try {
			
			List<MovieDocument> movies = service.listMovies(page, size, search);	
			
			return ResponseEntity.status(HttpStatus.OK).body(movies);
			
		} catch(Exception ex) {		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
		}
		
	}
	
	@PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMovie(@RequestBody MovieDocument movieBody) {
		
		if (movieBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<MovieDocument> movie = service.addMovie(movieBody);	
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
		}
		
	}
	
	@GetMapping(value = "/movies/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMovie(@PathVariable(value = "movieId") String movieId) {
		
		if (movieId == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<MovieDocument> movie = service.getMovie(movieId);	
						
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
		}	
		
	}
	
	@PutMapping(value = "/movies/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMovie(@PathVariable(value = "movieId") String movieId, @RequestBody MovieDocument movieBody) {
		
		if (movieBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<MovieDocument> movie = service.updateMovie(movieId, movieBody);
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
		}
		
	}
	
	@DeleteMapping(value = "/movies/{movieId}")
	public ResponseEntity<?> removeMovie(@PathVariable(value = "movieId") String movieId) {
		
		try {
			
			service.removeMovie(movieId);	
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
		}
	}

}
