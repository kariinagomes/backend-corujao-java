package com.sciensa.corujaoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sciensa.corujaoapi.entity.GenreDocument;

//no MongoRepository<> precisa informar a entidade e o tipo do id
@Repository
public interface GenreRepository extends MongoRepository<GenreDocument, String> {

}
