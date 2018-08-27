package de.tristan78.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.tristan78.spring5webapp.model.Author;
import de.tristan78.spring5webapp.model.Book;
import de.tristan78.spring5webapp.model.Publisher;
import de.tristan78.spring5webapp.repositories.AuthorRepository;
import de.tristan78.spring5webapp.repositories.BookRepository;
import de.tristan78.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher publisher1 = new Publisher("Harper Collins", "Address 123");
		Book ddd = new Book("Domain Driven Design", "1234", publisher1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		publisherRepository.save(publisher1);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher publisher2 = new Publisher("Wrox", "Address 456");
		Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		publisherRepository.save(publisher2);
		bookRepository.save(noEJB);
	}
	
}
