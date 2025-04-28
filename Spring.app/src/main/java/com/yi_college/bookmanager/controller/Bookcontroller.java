package com.yi_college.bookmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yi_college.bookmanager.model.Book;
import com.yi_college.bookmanager.service.BookService;

@RestController

public class Bookcontroller {
	private final BookService bookService;
	
	public Bookcontroller(BookService bookService) {
		this.bookService = bookService;
		
	}
	
	@GetMapping("/api/books")
	public  List<Book> getBooks(){
		return bookService.getBooks();
		
	}
	
	
	
	

}
