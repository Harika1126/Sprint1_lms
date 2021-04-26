package com.capgemini.lms.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.SuggestedBooksDao;
import com.capgemini.lms.dto.SuggestedBooksDto;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.SuggestedBooksService;


/*********************************************************************************************
 * 
 * @author SriHarika
 * Description: This class is used for service implementation of suggested books
 * Version: v1.1
 * Created date: 18 April 2021
 *
 *********************************************************************************************/

@Service
public class SuggestedBooksServiceImpl implements SuggestedBooksService
{
	@Autowired
	SuggestedBooksDao suggestedBooksDao;
	@Autowired
	BooksDao booksDao;

	/******************************************************************************************
	 * 
	 * Method: suggestBooks
	 * Description: This method is used to add a new suggested book
	 * 
	 * @param suggestedBooks
	 * @return SuggestedBooks
	 * Created date: 19 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public SuggestedBooks suggestBooks(SuggestedBooksDto suggestedBooksDto) 
	{
		Optional<Books> book=booksDao.findById(suggestedBooksDto.getBookId());
		if(!book.isPresent())
			throw new BookNotFoundException();
		else
		{ Books book1 = booksDao.findById(suggestedBooksDto.getBookId()).get();
		SuggestedBooks suggestedBooks = new SuggestedBooks();
		suggestedBooks.setBooks(book1);
		suggestedBooks.setAuthor(suggestedBooksDto.getAuthor());
		suggestedBooks.setDescription(suggestedBooks.getDescription());
		suggestedBooks.setPublications(suggestedBooksDto.getPublications());
		suggestedBooks.setStatus(suggestedBooksDto.getStatus());
		suggestedBooks.setSubject(suggestedBooksDto.getSubject());
		suggestedBooks.setSuggested_date(suggestedBooksDto.getSuggested_date());
		suggestedBooks.setTitle(suggestedBooksDto.getTitle());
		suggestedBooks.setId(suggestedBooksDto.getUserId());
		    return suggestedBooksDao.save(suggestedBooks);
		}
	}

	/*****************************************************************************************get*
	 * 
	 * Method: updateSuggestedBookStatus
	 * Description: This method is used to update suggested book details
	 * 
	 * @param suggestedBooks
	 * @return SuggestedBooks
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooksDto suggestedBooksDto) 
	{
		Optional<Books> book=booksDao.findById(suggestedBooksDto.getBookId());
		if(!book.isPresent())
			throw new BookNotFoundException();
		else
		{ Books book1 = booksDao.findById(suggestedBooksDto.getBookId()).get();
		SuggestedBooks suggestedBooks = new SuggestedBooks();
		suggestedBooks.setBooks(book1);
		suggestedBooks.setAuthor(suggestedBooksDto.getAuthor());
		suggestedBooks.setDescription(suggestedBooks.getDescription());
		suggestedBooks.setPublications(suggestedBooksDto.getPublications());
		suggestedBooks.setStatus(suggestedBooksDto.getStatus());
		suggestedBooks.setSubject(suggestedBooksDto.getSubject());
		suggestedBooks.setSuggested_date(suggestedBooksDto.getSuggested_date());
		suggestedBooks.setTitle(suggestedBooksDto.getTitle());
		suggestedBooks.setId(suggestedBooksDto.getUserId());
		    return suggestedBooksDao.save(suggestedBooks);
		}
	}

	/******************************************************************************************
	 * 
	 * Method: deleteSuggestedBooks
	 * Description: This method is used to delete a suggested book
	 * 
	 * @param id
	 * @return 
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public void deleteSuggestedBooks(int id)
	{
		if(suggestedBooksDao.existsById(id))
			 suggestedBooksDao.deleteById(id);
	    else
            throw new BookNotFoundException();
	
	}

	/******************************************************************************************
	 * 
	 * Method: viewSuggestedBookDetails
	 * Description: This method is used to view the suggested book details when id is specified
	 * 
	 * @param id
	 * @return SuggestedBooks
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public SuggestedBooks viewSuggestedBookDetails(int id) 
	{
		if(suggestedBooksDao.existsById(id))
			return  suggestedBooksDao.findById(id).get();
		else 
			throw new BookNotFoundException();
	}

	/******************************************************************************************
	 * 
	 * Method: viewSuggestedBooks
	 * Description: This method is used to view a suggested book list
	 * 
	 * @param 
	 * @return List<SuggestedBooks>
	 * Created date: 18 April 2021
	 * 
	 ********************************************************************************************/
	@Override
	public List<SuggestedBooks> viewSuggestedBooksList() 
	{

		return suggestedBooksDao.findAll();
	}
	

}

