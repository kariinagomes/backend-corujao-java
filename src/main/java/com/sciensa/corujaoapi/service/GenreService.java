package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.GenreDocument;

public interface GenreService {
	public List<GenreDocument> listGenres(Integer page, Integer size, String search);
	public GenreDocument addGenre(GenreDocument genreBody);
	public Optional<GenreDocument> getGenre(String genreId);
	public GenreDocument updateGenre(String genreId, GenreDocument genreBody);
}
