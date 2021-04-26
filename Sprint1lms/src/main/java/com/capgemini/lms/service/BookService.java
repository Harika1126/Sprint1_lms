package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Books;

public interface BookService {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book);
	public int removeBook(int bookid);
	public List<Books> searchBookByTitle(String keyword);
	public List<Books> searchBookBySubject(String keyword);
	public List<Books> viewAllBooks();
}