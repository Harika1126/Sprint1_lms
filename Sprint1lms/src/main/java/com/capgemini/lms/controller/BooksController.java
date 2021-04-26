package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.BookService;

@RestController
@RequestMapping("/book")
public class BooksController {
	@Autowired
	BookService booksService;
	

	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<Books>> getAllBooks(){
		return new ResponseEntity<List<Books>> (booksService.viewAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping(value="/sub/{Subject}",produces="application/json")
	public ResponseEntity<List<Books>> getBooksBySubject(@PathVariable("Subject")String Subject) { 
		List<Books> b=booksService.searchBookBySubject(Subject);
		if(b.isEmpty())	
			throw new BookNotFoundException("No book found with given value "+ Subject);
		else
			return new ResponseEntity<List<Books>>(booksService.searchBookBySubject(Subject),HttpStatus.OK);
         
	}
	@GetMapping(value="/{Title}",produces="application/json")
	public ResponseEntity<List<Books>> getBooksByTitle(@PathVariable("Title")String Title){ 
		List<Books> b=booksService.searchBookByTitle(Title);
		if(b.isEmpty())	
			throw new BookNotFoundException("No book found with given value "+ Title);
		else
			return new ResponseEntity<List<Books>>(booksService.searchBookByTitle(Title),HttpStatus.OK);
	}
	@PostMapping("/addBook")
	public ResponseEntity<HttpStatus> addBooks(@RequestBody Books book){
		booksService.addBook(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyBooks(@RequestBody Books book){
		booksService.updateBookDetails(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);	
	}
	
@DeleteMapping(value="/{bookid}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookid")int bookid)
	{
	
		try {
			booksService.removeBook(bookid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
	
		catch(Exception e)
		{
			throw new BookNotFoundException("No book found with given value "+ bookid); 
		}
	}
}