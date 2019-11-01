package com.sciensa.corujaoapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.MovieDocument;
import com.sciensa.corujaoapi.repository.MovieRepository;
import com.sciensa.corujaoapi.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	@Override
	public List<MovieDocument> listMovies(Integer page, Integer size, String search) {
		
		Page<MovieDocument> movies = repo.findAll(PageRequest.of(page - 1, size));
		
		if (!search.isEmpty()) {	
			
			List<MovieDocument> moviesFiltered = new ArrayList<>();
			
			for (MovieDocument movie : movies.toList()) {
				if (movie.getTitle().toLowerCase().contains(search.toLowerCase())) {
					moviesFiltered.add(movie);
				}
			}
			
			return moviesFiltered;
		}

		return movies.toList();
	}

	@Override
	public Optional<MovieDocument> addMovie(MovieDocument movieBody) {
		MovieDocument movie = repo.insert(movieBody);
		
		return repo.findById(movie.getId());
	}

	@Override
	public Optional<MovieDocument> getMovie(String movieId) {
		return repo.findById(movieId);
	}

	@Override
	public Optional<MovieDocument> updateMovie(String movieId, MovieDocument movieBody) {
		
		if (repo.existsById(movieId)) {
			MovieDocument movie = repo.save(movieBody);
			
			return repo.findById(movie.getId());
		}
		
		return null;
	}

	@Override
	public void removeMovie(String movieId) {
		if (repo.existsById(movieId)) {
			repo.deleteById(movieId);
		}
	}
}
