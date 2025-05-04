package com.yi_college.bookmanager.model;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookModel {

	private Integer id;
	private String title;
	private String author;
	private String publisher;
	private LocalDate publishedDate;
	private Integer stock;

	//	public BookModel {
	//		// TODO 自動生成されたコンストラクター・スタブ
	//
	//	this.id = id;
	//	this.title = title;
	//	this.author = author;
	//	this.publisher = publisher;
	//	this.publicationdate = publicationdate;		
	//	this.stock = stock;
	//	

}
