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
import org.springframework.web.bind.annotation.RestController;

import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.service.MovieService;


@RestController
@RequestMapping(value = "/v1")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MovieDocument>> listMovies() {
		
		try {
			
			List<MovieDocument> movies = service.listMovies();	
			
			return ResponseEntity.status(HttpStatus.OK).body(movies);
			
		} catch(Exception ex) {		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieDocument> addMovie(@RequestBody MovieDocument movieBody) {
		
		if (movieBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			MovieDocument movie = service.addMovie(movieBody);	
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(value = "/movies/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<MovieDocument>> getMovie(@PathVariable(value = "movieId") String movieId) {
		
		if (movieId == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<MovieDocument> movie = service.getMovie(movieId);	
						
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
		
	}
	
	@PutMapping(value = "/movies/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieDocument> updateMovie(@PathVariable(value = "movieId") String movieId, @RequestBody MovieDocument movieBody) {
		
		if (movieBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			MovieDocument movie = service.updateMovie(movieId, movieBody);
			
			return ResponseEntity.status(HttpStatus.OK).body(movie);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping(value = "/movies/{movieId}")
	public ResponseEntity<?> removeMovie(@PathVariable(value = "movieId") String movieId) {
		
		try {
			
			service.removeMovie(movieId);	
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
