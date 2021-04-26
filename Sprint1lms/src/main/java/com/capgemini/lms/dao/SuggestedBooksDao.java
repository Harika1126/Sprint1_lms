package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.exception.BookNotFoundException;

@Repository
public interface SuggestedBooksDao extends JpaRepository <SuggestedBooks, Integer>{
//	public int suggestBooks(List<Books> bookList); 
//	public int updateSuggestedBookStatus(SuggestedBooks book) throws BookNotFoundException;
//	public int deleteSuggestedBooks(int id) throws BookNotFoundException;
//	public SuggestedBooks viewSuggestedBookDetails(int id);
//	public List<SuggestedBooks> viewSuggestedBooksList();
	
}