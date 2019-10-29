package com.sciensa.corujaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorujaoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorujaoapiApplication.class, args);
	}

}

/*
 * Expõe os controladores rest para as aplicações;
 * os controladores rest acessam os serviços;
 * os serviços acessam a camada de acesso a dados (repository);
 * ao lado das últimas duas camadas, tem a camada de domínio
 */

/*
 * Ordem que criei os arquivos:
 * 	package entity -> class Genre
 *  package controller -> class GenreController
 *  package repository -> interface GenreRepository
 *  package service -> interface GenreService
 *  	package service impl -> classe GenreSerbiveImpl
 */