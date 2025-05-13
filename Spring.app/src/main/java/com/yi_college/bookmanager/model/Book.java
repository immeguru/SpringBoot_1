package com.yi_college.bookmanager.model;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String title;
	private String author;
	private String publisher;
	private LocalDate publishedDate;
	private Integer stock;

	public Book(String title, String author, String publisher, LocalDate publicationDate, Integer stock) {

		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publicationDate;
		this.stock = stock;

	}

}
