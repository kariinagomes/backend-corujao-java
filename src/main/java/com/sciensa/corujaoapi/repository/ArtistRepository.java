package com.sciensa.corujaoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sciensa.corujaoapi.entity.ArtistDocument;

@Repository
public interface ArtistRepository extends MongoRepository<ArtistDocument, String> {

}
