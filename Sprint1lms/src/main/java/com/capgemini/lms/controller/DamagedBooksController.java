package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.dto.DamagedBooksDto;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.DamagedBooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*************************************************************************************************
 * 
 * 
 * @author SriHarika
 * Description: This class is used for controller where we can add, update, view Damaged Books
 * Version: v1.1
 * Created date: 21 April 2021
 * 
 * 
 **************************************************************************************************/

@Api("Damaged Books Controller")
@RestController
@RequestMapping(value="/DamagedBooks")

public class DamagedBooksController
{
	@Autowired
	DamagedBooksService damagedBooksService;
	/********************************************************************************
	 * 
	 * Method : addDamagedBooks
	 * DEscription: method used for adding new Damaged Books
	 * 
	 * 
	 * @param damagedBooks
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP POST requests onto add damaged books
	 * @Created date: 19 April 2021
	 * 
	 *  
	 *********************************************************************************/
	
	@ApiOperation(value="Add Damaged Books")
	@PostMapping(value="/insertDamagedBooks")
	public ResponseEntity<String> insertDamagedBooks(@RequestBody DamagedBooksDto damagedBooksDto)
	{
		try {
		damagedBooksService.addDamagedBooks(damagedBooksDto);
		return new ResponseEntity<>("Inserted DamagedBooks successfully" ,HttpStatus.OK);
		  }
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter a book which is damaged");
      	}
	}
	
	/********************************************************************************
	 * 
	 * Method : updateDamagedBooks
	 * DEscription: method used for updating Damaged Books details
	 * 
	 * 
	 * @param damagedBooks
	 * @return ResponseEntity<String>
	 * @PutMapping Annotation for mapping HTTP PUT requests onto update damaged books
	 * @Created date: 19 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value="update Damaged Books")
	@PutMapping(value="/updateDamageBooks")
	public ResponseEntity<String> updateDamagedBooksDetails(@RequestBody DamagedBooksDto damagedBooksDto)
	{
		try {
		damagedBooksService.updateDamagedBookDetails(damagedBooksDto);
		return new ResponseEntity<>("Updated DamagedBook details successfully" ,HttpStatus.OK);
		}
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter Valid Id");
		}
	}
	
	/********************************************************************************
	 * 
	 * Method : viewDamagedBooks
	 * DEscription: method used for viewing Damaged books list
	 * 
	 * 
	 * @param damagedBooks
	 * @return List<Damagedbooks>
	 * @GetMapping Annotation for mapping HTTP GET requests to view damaged books
	 * @Created date: 19 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value="View Damaged Books")
	@GetMapping(value="/ViewDamagedBooks")
	public List<DamagedBooks> getAllDamagedBooks()
	{
		return damagedBooksService.viewDamagedBooksList();
	}
	
	/********************************************************************************
	 * 
	 * Method : viewDamagedBooksById
	 * DEscription: method used for viewing Damaged book when specific id is given
	 * 
	 * 
	 * @param id
	 * @return DamagedBooks
	 * @GetMapping Annotation for mapping HTTP GET requests to view damaged book by id
	 * @Created date: 19 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value="View Damaged Books By id")
	@GetMapping(value="/ViewDamagedBooksById/{id}")
	public DamagedBooks getAllDamagedBooksById(@PathVariable int id)
	{
		try {
		return damagedBooksService.viewDamagedBookById(id);
		}
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter Valid Id");
		}
	}
	
}

