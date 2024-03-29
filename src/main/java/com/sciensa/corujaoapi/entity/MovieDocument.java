package com.sciensa.corujaoapi.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="movie")
public class MovieDocument {
	private String id;
	private String title;
	private Integer releaseYear;
	@DBRef
	private List<GenreDocument> genres;
	@DBRef
	private ArtistDocument director;
	@DBRef
	private List<ArtistDocument> cast;
	@CreatedDate
	private Date cretaedAt;
	@LastModifiedDate
	private Date updatedAt;
	
	public MovieDocument(String id, String title, Integer releaseYear, List<GenreDocument> genres,
			ArtistDocument director, List<ArtistDocument> cast, Date cretaedAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genres = genres;
		this.director = director;
		this.cast = cast;
		this.cretaedAt = cretaedAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<GenreDocument> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreDocument> genres) {
		this.genres = genres;
	}

	public ArtistDocument getDirector() {
		return director;
	}

	public void setDirector(ArtistDocument director) {
		this.director = director;
	}

	public List<ArtistDocument> getCast() {
		return cast;
	}

	public void setCast(List<ArtistDocument> cast) {
		this.cast = cast;
	}

	public Date getCretaedAt() {
		return cretaedAt;
	}

	public void setCretaedAt(Date cretaedAt) {
		this.cretaedAt = cretaedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
