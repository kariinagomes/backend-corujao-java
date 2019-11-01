package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.MovieDocument;

public interface MovieService {
	public List<MovieDocument> listMovies(Integer page, Integer size, String search);
	public Optional<MovieDocument> addMovie(MovieDocument movieBody);
	public Optional<MovieDocument> getMovie(String movieId);
	public Optional<MovieDocument> updateMovie(String movieId, MovieDocument movieBody);
	public void removeMovie(String movieId);
}
