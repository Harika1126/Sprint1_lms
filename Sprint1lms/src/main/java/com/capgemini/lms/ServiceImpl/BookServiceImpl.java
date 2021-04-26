package com.capgemini.lms.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.service.BookService;

@Service
public class BookServiceImpl implements BookService  {
	 @Autowired
     BooksDao booksdao;
     
     
	@Override
	public Books addBook(Books book) {
		booksdao.save(book);
		return book;
	}

	@Override
	public Books updateBookDetails(Books book) {
		booksdao.save(book);
		return book;
		
	}

	@Override
	public int removeBook(int bookid) {
		booksdao.deleteById(bookid);
		return bookid;
		
	}

	@Override
	public List<Books> searchBookByTitle(String keyword) {
		return booksdao.searchBookByTitle(keyword);
		
	}

	@Override
	public List<Books> searchBookBySubject(String keyword) {
		return booksdao.searchBookBySubject(keyword);
	}

	@Override
	public List<Books> viewAllBooks() {
		return booksdao.findAll();
	}


}