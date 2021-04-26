package com.capgemini.lms.dto;

import java.time.LocalDate;
import java.util.Date;

public class SuggestedBooksDto 
{
	private int bookId;
	private String title;
	private String subject;
	private String author;
	private String publications;
	private String description;
	private LocalDate suggested_date;
	private String status;
	private int userId;
	public String getTitle() {
		return title;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getPublications() {
		return publications;
	}
	public void setPublications(String publications) {
		this.publications = publications;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getSuggested_date() {
		return suggested_date;
	}
	public void setSuggested_date(LocalDate suggested_date) {
		this.suggested_date = suggested_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SuggestedBooksDto(int bookId,String title, String subject, String author, String publications, String description,
			LocalDate suggested_date, String status, int userId) {
		super();
		this.bookId=bookId;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
		this.userId = userId;
	}
	public SuggestedBooksDto() {
		super();
	}

	@Override
	public String toString() {
		return "SuggestedBooksDto [bookId=" + bookId + ", title=" + title + ", subject=" + subject + ", author="
				+ author + ", publications=" + publications + ", description=" + description + ", suggested_date="
				+ suggested_date + ", status=" + status + ", userId=" + userId + "]";
	}
	

}
