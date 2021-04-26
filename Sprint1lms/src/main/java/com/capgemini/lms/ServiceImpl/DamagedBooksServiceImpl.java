package com.capgemini.lms.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.DamagedBooksDao;
import com.capgemini.lms.dto.DamagedBooksDto;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.DamagedBooksService;

/*********************************************************************************************
 * 
 * @author SriHarika
 * Description: This class is used for service implementation of damaged books
 * Version: v1.1
 * Created date: 19 April 2021
 *
 *********************************************************************************************/
@Service

public class DamagedBooksServiceImpl implements DamagedBooksService
{
	@Autowired
	DamagedBooksDao damagedBooksDao;
	@Autowired
	BooksDao booksDao;

	/******************************************************************************************
	 * 
	 * Method: addDamagedBooks
	 * Description: This method is used to add a new damaged book
	 * 
	 * @param damagedBooks
	 * @return DamagedBooks
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Transactional
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooksDto damagedBooksDto) 
	{
		Optional<Books> book=booksDao.findById(damagedBooksDto.getBookId());
		if(!book.isPresent())
			throw new BookNotFoundException();
		else
		{ Books book1 = booksDao.findById(damagedBooksDto.getBookId()).get();
		DamagedBooks damagedBooks= new DamagedBooks();
		damagedBooks.setBook(book1);
		damagedBooks.setQuantity(damagedBooksDto.getQuantity());
		damagedBooks.setDescription(damagedBooksDto.getDescription());
		
		    return damagedBooksDao.save(damagedBooks);
		}
	}

	/******************************************************************************************
	 * 
	 * Method: updateDamagedBooks
	 * Description: This method is used to update damaged books
	 * 
	 * @param damagedBooks
	 * @return DamagedBooks
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooksDto damagedBooksDto) 
	{
		Optional<Books> book=booksDao.findById(damagedBooksDto.getBookId());
		if(!book.isPresent())
			throw new BookNotFoundException();
		else
		{Books book1= booksDao.findById(damagedBooksDto.getBookId()).get();
		DamagedBooks damagedBooks= new DamagedBooks();
		damagedBooks.setBook(book1);
		damagedBooks.setQuantity(damagedBooksDto.getQuantity());
		damagedBooks.setDescription(damagedBooksDto.getDescription());
	        return damagedBooksDao.save(damagedBooks);
		}
	  
	}

	/******************************************************************************************
	 * 
	 * Method: viewDamagedBooks
	 * Description: This method is used to view damaged books list
	 * 
	 * @param 
	 * @return List<DamagedBooks>
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		
		return damagedBooksDao.findAll();
	}

	/******************************************************************************************
	 * 
	 * Method: viewDamagedBooksById
	 * Description: This method is used to view damaged book when specific id is given
	 * 
	 * @param id
	 * @return DamagedBooks
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public DamagedBooks viewDamagedBookById(int id) {
		
		return damagedBooksDao.findById(id).get();
	}
	
	
}

