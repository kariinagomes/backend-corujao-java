package com.sciensa.corujaoapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.ArtistDocument;
import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.repository.ArtistRepository;
import com.sciensa.corujaoapi.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	private ArtistRepository repo;

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
	public Optional<ArtistDocument> getArtist(String id) {
		return repo.findById(id);
	}

	@Override
	public ArtistDocument updateArtist(String id, ArtistDocument artistBody) {
		if (repo.existsById(id)) {
			return repo.save(artistBody);
		}
		
		return null;
	}

	@Override
	public MovieDocument getArtistFilmography(String artistId) {
		// TODO Auto-generated method stub
		return null;
	}

}
