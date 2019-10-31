package com.sciensa.corujaoapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.ArtistDocument;
import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.repository.ArtistRepository;
import com.sciensa.corujaoapi.repository.MovieRepository;
import com.sciensa.corujaoapi.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	private ArtistRepository repo;
	@Autowired
	private MovieRepository repoMovie;

	@Override
	public List<ArtistDocument> listArtists() {
		return repo.findAll();
	}

	@Override
	public ArtistDocument addArtist(ArtistDocument artistBody) {
		ArtistDocument artist = repo.insert(artistBody);
		return artist;
	}

	@Override
	public Optional<ArtistDocument> getArtist(String artistId) {
		return repo.findById(artistId);
	}

	@Override
	public ArtistDocument updateArtist(String artistId, ArtistDocument artistBody) {
		if (repo.existsById(artistId)) {
			return repo.save(artistBody);
		}
		
		return null;
	}

	@Override
	public List<MovieDocument> getArtistFilmography(String artistId) {
		
		List<MovieDocument> movies = repoMovie.findAll();
		List<MovieDocument> filmography = new ArrayList<>();
		
		for (MovieDocument movie : movies) {
			
			List<ArtistDocument> artists = movie.getCast();
			
			for (ArtistDocument artist : artists) {
				if (artist.getId() != null && artist.getId().equals(artistId)) {
					filmography.add(movie);
				}
			}
		}
		
		return filmography;
	}

}
