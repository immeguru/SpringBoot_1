package com.yi_college.bookmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.yi_college.bookmanager.model.Book;
import com.yi_college.bookmanager.model.BookModel;
import com.yi_college.bookmanager.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired

	public BookService(BookRepository bookRepository) {

		this.bookRepository = bookRepository;

	}

	public List<BookModel> getAllBooks() {
		List<Book> books = bookRepository.findAll();

		if (books.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		List<BookModel> bookModels = new ArrayList<>();

		for (Book book : books) {
			BookModel model = new BookModel(
					book.getId(),
					book.getTitle(),
					book.getAuthor(),
					book.getPublisher(),
					book.getPublishedDate(),
					book.getStock());

			bookModels.add(model);

		}

		return bookModels;

	}

	public BookModel createBook(BookModel bookModel) {

		Book book = new Book(
				bookModel.getTitle(),
				bookModel.getAuthor(),
				bookModel.getPublisher(),
				bookModel.getPublishedDate(),
				bookModel.getStock());

		Book saved = bookRepository.save(book);

		return new BookModel(
				saved.getId(),
				saved.getTitle(),
				saved.getAuthor(),
				saved.getPublisher(),
				saved.getPublishedDate(),
				saved.getStock()

		);

	}

	public BookModel updateBook(Integer id, BookModel bookModel) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("書籍が見つかりませんでした"));

		book.setTitle(bookModel.getTitle());
		book.setAuthor(bookModel.getAuthor());
		book.setPublisher(bookModel.getPublisher());
		book.setPublishedDate(bookModel.getPublishedDate());
		book.setStock(bookModel.getStock());

		Book updated = bookRepository.save(book);

		return new BookModel(
				updated.getId(),
				updated.getTitle(),
				updated.getAuthor(),
				updated.getPublisher(),
				updated.getPublishedDate(),
				updated.getStock());
	}

	public void deleteBook(Integer id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("書籍が見つかりませんでした"));
		bookRepository.delete(book);

	}
}