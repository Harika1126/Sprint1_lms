package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dto.SuggestedBooksDto;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.SuggestedBooks;

public interface SuggestedBooksService {
	public SuggestedBooks suggestBooks(SuggestedBooksDto suggestedBooksDto); 
	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooksDto suggestedBooksDto);
	public void deleteSuggestedBooks(int id);
	public SuggestedBooks viewSuggestedBookDetails(int id);
	public List<SuggestedBooks> viewSuggestedBooksList();
}