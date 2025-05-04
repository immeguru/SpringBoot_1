package com.yi_college.bookmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yi_college.bookmanager.model.BookModel;
import com.yi_college.bookmanager.service.BookService;

@RestController

public class Bookcontroller {
	private final BookService bookService;

	public Bookcontroller(BookService bookService) {
		this.bookService = bookService;

	}

	@GetMapping("/api/books")
	public List<BookModel> getBooks() {
		return bookService.getAllBooks();

	}

	@PostMapping("/api/books")
	@ResponseStatus(HttpStatus.CREATED)
	public BookModel createBook(@RequestBody BookModel bookModel) {
		return bookService.createBook(bookModel);

	}

	@PutMapping("/api/books/{id}")
	public BookModel updateBook(@PathVariable Integer id, @RequestBody BookModel bookModel) {
		return bookService.updateBook(id, bookModel);

	}

	@DeleteMapping("/api/books/{id}")
	public void delete(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}

}
