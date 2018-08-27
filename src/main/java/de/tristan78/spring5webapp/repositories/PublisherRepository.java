package de.tristan78.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import de.tristan78.spring5webapp.model.Publisher;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
