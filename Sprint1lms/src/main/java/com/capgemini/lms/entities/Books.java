package com.capgemini.lms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/*********************************************************************************************
 * 
 * @author SriHarika
 * Description: This class is used for entity mapping and for generating getters and setter for Books
 * Version: v1.1
 * Created date: 16 April 2021
 *
 *********************************************************************************************/
@Entity
@Table(name="Books1")
public class Books 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String title;
	private String subject;
	private String author;
	private String publisher;
	private int published_year;
	private String isbn_code;
	private int quantity;
	private double book_cost;
	private String shelf_details;
	
	public Books(String string, String string2, String string3, String string4, int i, String string5, int j, double d, String string6) {
		super();
	}
	

	public int getBookid() {
		return bookid;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getPublished_year() {
		return published_year;
	}


	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}


	public String getIsbn_code() {
		return isbn_code;
	}


	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getBook_cost() {
		return book_cost;
	}


	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}


	public String getShelf_details() {
		return shelf_details;
	}


	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}


	public Books() {
		super();
	}


	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", subject=" + subject + ", author=" + author
				+ ", publisher=" + publisher + ", published_year=" + published_year + ", isbn_code=" + isbn_code
				+ ", quantity=" + quantity + ", book_cost=" + book_cost + ", shelf_details=" + shelf_details + "]";
	}
	

}