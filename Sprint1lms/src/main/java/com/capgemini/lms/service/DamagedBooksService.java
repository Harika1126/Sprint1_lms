package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dto.DamagedBooksDto;
import com.capgemini.lms.entities.DamagedBooks;

public interface DamagedBooksService {
	public DamagedBooks addDamagedBooks(DamagedBooksDto damagedBooksDto);
	public DamagedBooks updateDamagedBookDetails(DamagedBooksDto books);
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooks viewDamagedBookById(int id);
}

