package de.tristan78.spring5webapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import de.tristan78.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
}
