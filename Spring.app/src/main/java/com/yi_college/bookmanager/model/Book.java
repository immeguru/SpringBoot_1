package com.yi_college.bookmanager.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	
	private int id;
	private String title;
	private String author;
	private String publisher;
	private LocalDate publicationdate;
	private int stock;
	
	public Book(int id, String title, String author, String publisher, LocalDate publicationDate, int stock) {
		// TODO 自動生成されたコンストラクター・スタブ
//	    this.setId(id);
//		this.setTitle(title);
//		this.setAuthor(author);
//		this.setPublisher(publisher);
//		this.setPublicationdate(publicationDate);
//		this.setStock(stock);
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationdate = publicationDate;
		this.stock = stock;
		
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public LocalDate getPublicationdate() {
//		return publicationdate;
//	}
//	public void setPublicationdate(LocalDate publicationdate) {
//		this.publicationdate = publicationdate;
//	}
//	public String getPublisher() {
//		return publisher;
//	}
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}
//	public int getStock() {
//		return stock;
//	}
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
	
}




