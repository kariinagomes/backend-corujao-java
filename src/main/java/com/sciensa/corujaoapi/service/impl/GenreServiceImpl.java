package com.sciensa.corujaoapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciensa.corujaoapi.entity.GenreDocument;
import com.sciensa.corujaoapi.repository.GenreRepository;
import com.sciensa.corujaoapi.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	// mecanismo de injeção de dependencia automatico do spring
	@Autowired
	private GenreRepository repo;
	
	@Override
	public List<GenreDocument> listGenres() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
