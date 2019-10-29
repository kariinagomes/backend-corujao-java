package com.sciensa.corujaoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sciensa.corujaoapi.entity.MovieDocument;

@Repository
public interface MovieRepository extends MongoRepository<MovieDocument, String> {

}