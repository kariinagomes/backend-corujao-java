package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.GenreDocument;

public interface GenreService {
	public List<GenreDocument> listGenres();
	public GenreDocument addGenre(GenreDocument genreBody);
	public Optional<GenreDocument> getGenre(String id);
	public GenreDocument updateGenre(String id, GenreDocument genreBody);
}
