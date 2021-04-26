package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.exception.BookNotFoundException;

@Repository
public interface DamagedBooksDao extends JpaRepository<DamagedBooks,Integer>
{
//	public int addDamagedBooks(DamagedBooks damagedBooks);
//	public int updateDamagedBookDetails() throws BookNotFoundException;
//	public List<DamagedBooks> viewDamagedBooksList();
//	public DamagedBooks viewDamagedBookById(int id) throws BookNotFoundException;
}
