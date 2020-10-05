package com.hygogg.books.models;


public class Book {

	public String title;
	public String author;
	public Integer numPages;
	public Double price;
	
	public Book(String title, String author, Integer numPages, Double price) {
		this.title = title;
		this.author = author;
		this.numPages = numPages;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getNumPages() {
		return numPages;
	}

	public void setNumPages(Integer numPages) {
		this.numPages = numPages;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
