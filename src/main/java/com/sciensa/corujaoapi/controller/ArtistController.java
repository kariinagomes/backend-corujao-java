package com.sciensa.corujaoapi.controller;

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

import com.sciensa.corujaoapi.entity.ArtistDocument;
import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.service.ArtistService;

@RestController
@RequestMapping(value = "/v1")
public class ArtistController {

	@Autowired
	private ArtistService service;

	@GetMapping(value = "/artists", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ArtistDocument>> listArtists() {
		
		try {
			
			List<ArtistDocument> artists = service.listArtists();	
			
			return ResponseEntity.status(HttpStatus.OK).body(artists);
			
		} catch(Exception ex) {		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping(value = "/artists", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArtistDocument> addArtist(@RequestBody ArtistDocument artistBody) {
		
		if (artistBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			ArtistDocument artist = service.addArtist(artistBody);	
			
			return ResponseEntity.status(HttpStatus.OK).body(artist);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(value = "/artists/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<ArtistDocument>> getArtist(@PathVariable(value = "id") String id) {
		
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			Optional<ArtistDocument> artist = service.getArtist(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(artist);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
		
	}
	
	@PutMapping(value = "/artists/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArtistDocument> updateArtist(@PathVariable(value = "id") String id, @RequestBody ArtistDocument artistBody) {
		
		if (artistBody == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try {
			
			ArtistDocument artist = service.updateArtist(id, artistBody);
			
			return ResponseEntity.status(HttpStatus.OK).body(artist);
			
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(value = "/artists/{id}/filmography", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MovieDocument>> getArtistFilmography(@PathVariable(value = "artistId") String artistId) {
		
		return null;
		
	}
}
