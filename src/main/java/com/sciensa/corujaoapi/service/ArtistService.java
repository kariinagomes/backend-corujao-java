package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.ArtistDocument;
import com.sciensa.corujaoapi.entity.MovieDocument;

public interface ArtistService {
	public List<ArtistDocument> listArtists();
	public ArtistDocument addArtist(ArtistDocument artistBody);
	public Optional<ArtistDocument> getArtist(String id);
	public ArtistDocument updateArtist(String id, ArtistDocument artistBody);
	public MovieDocument getArtistFilmography(String artistId);
}
