package com.sciensa.corujaoapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.repository.MovieRepository;
import com.sciensa.corujaoapi.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	@Override
	public List<MovieDocument> listMovies() {
		return repo.findAll();
	}

	@Override
	public MovieDocument addMovie(MovieDocument movieBody) {
		return repo.insert(movieBody);
	}

	@Override
	public Optional<MovieDocument> getMovie(String id) {
		return repo.findById(id);
	}

	@Override
	public MovieDocument updateMovie(String id, MovieDocument movieBody) {
		if (repo.existsById(id)) {
			return repo.save(movieBody);
		}
		
		return null;
	}

	@Override
	public void removeMovie(String id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}
