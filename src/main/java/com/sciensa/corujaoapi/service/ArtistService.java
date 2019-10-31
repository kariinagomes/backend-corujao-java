package com.sciensa.corujaoapi.service;

import java.util.List;
import java.util.Optional;

import com.sciensa.corujaoapi.entity.ArtistDocument;
import com.sciensa.corujaoapi.entity.MovieDocument;

public interface ArtistService {
	public List<ArtistDocument> listArtists();
	public ArtistDocument addArtist(ArtistDocument artistBody);
	public Optional<ArtistDocument> getArtist(String artistId);
	public ArtistDocument updateArtist(String artistId, ArtistDocument artistBody);
	public List<MovieDocument> getArtistFilmography(String artistId);
}
