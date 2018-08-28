package de.tristan78.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.tristan78.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	
	public BookController(de.tristan78.spring5webapp.repositories.BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
	
}
