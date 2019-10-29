package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.MovieDocument;

public interface MovieService {
	public List<MovieDocument> listMovies();
	public MovieDocument addMovie(MovieDocument movieBody);
	public Optional<MovieDocument> getMovie(String id);
	public MovieDocument updateMovie(String id, MovieDocument movieBody);
	public void removeMovie(String id);
}
