package com.sciensa.corujaoapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.GenreDocument;
import com.sciensa.corujaoapi.repository.GenreRepository;
import com.sciensa.corujaoapi.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repo;
	
	@Override
	public List<GenreDocument> listGenres(Integer page, Integer size, String search) {
		
		Page<GenreDocument> genres = repo.findAll(PageRequest.of(page - 1, size));
		
		if (!search.isEmpty()) {	
			
			List<GenreDocument> genresFiltered = new ArrayList<>();
			
			for (GenreDocument genre : genres.toList()) {
				if (genre.getDescription().toLowerCase().contains(search.toLowerCase())) {
					genresFiltered.add(genre);
				}
			}
			
			return genresFiltered;
		}

		return genres.toList();
	}

	@Override
	public GenreDocument addGenre(GenreDocument genreBody) {
		return repo.insert(genreBody);
	}

	@Override
	public Optional<GenreDocument> getGenre(String genreId) {
		return repo.findById(genreId);
	}

	@Override
	public GenreDocument updateGenre(String genreId, GenreDocument genreBody) {
		if (repo.existsById(genreId)) {
			return repo.save(genreBody);
		}
		
		return null;
	}

}
