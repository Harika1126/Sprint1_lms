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

import com.capgemini.lms.dto.SuggestedBooksDto;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.SuggestedBooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/****************************************************************************************************
 * 
 * 
 * @author SriHarika
 * Description: This class is used for controller where we can add, update, view and delete Suggested Books
 * Version: v1.1
 * Created date: 21 April 2021
 * 
 * 
 *******************************************************************************************************/
@Api("Suggested Books Controller")
@RestController
@RequestMapping(value="/SuggestedBooks")
public class SuggestedBooksController 
{
	@Autowired
	SuggestedBooksService suggestedBooksService;
	
	@ApiOperation(value="/Suggested Books")
	
	/********************************************************************************
	 * 
	 * Method : suggestBooks
	 * DEscription: method used for adding new Suggested Books
	 * 
	 * 
	 * @param suggestedBooks
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP POST requests onto add suggested books
	 * @Created date: 20 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@PostMapping(value="/suggestBooks")
	public ResponseEntity<String> suggestBooks(@RequestBody SuggestedBooksDto suggestedBooksDto)
	{
		try {
			suggestedBooksService.suggestBooks(suggestedBooksDto);
			return new ResponseEntity<String>("Added suggested books sucessfully" ,HttpStatus.OK);
			}
			catch(BookNotFoundException e)
			{
				throw new BookNotFoundException("Enter Valid Id");
			}
	}
	
	/********************************************************************************
	 * 
	 * Method : updateSuggestedBooks
	 * DEscription: method used for updating Suggested Books
	 * 
	 * 
	 * @param suggestedBooks
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP PUT requests onto update suggested books
	 * @Created date: 20 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value="/updateSuggested Books")
	@PutMapping(value="/updateSuggestedBooks")
	public ResponseEntity<String> updateSuggestedBooks (@RequestBody SuggestedBooksDto suggestedBooksDto)
	{
		try {
		suggestedBooksService.updateSuggestedBookStatus(suggestedBooksDto);
		return new ResponseEntity<String>("Updated SuggestedBook status sucessfully" ,HttpStatus.OK);
		}
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter Valid Id");
		}
	}
	
	/********************************************************************************
	 * 
	 * Method : deleteSuggestedBooks
	 * DEscription: method used for adding new Suggested Books
	 * 
	 * 
	 * @param id
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP DELETE requests onto delete suggested books
	 * @Created date: 20 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value="delete Suggested Books")
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<String> deleteSuggestedBooks(@PathVariable int id) 
	{
		try {
		suggestedBooksService.deleteSuggestedBooks(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter Valid Id");
		}
	}
	
	/********************************************************************************
	 * 
	 * Method : ViewSuggestedBooks
	 * DEscription: method used for viewing suggested books
	 * 
	 * 
	 * @param 
	 * @return List<SuggestedBooks>
	 * @PostMapping Annotation for mapping HTTP GET requests onto view suggested books
	 * @Created date: 20 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value=" View Suggested Books")
	@GetMapping(value="/ViewSuggestedBooks")
	public List<SuggestedBooks> getAllSuggestedBooks(){
		return suggestedBooksService.viewSuggestedBooksList();
	}
	
	/********************************************************************************
	 * 
	 * Method : ViewSuggestedBooksById
	 * DEscription: method used for viewing suggested books when a specific id is given
	 * 
	 * 
	 * @param id
	 * @return SuggestedBooks
	 * @PostMapping Annotation for mapping HTTP GET requests onto view suggested books
	 * @Created date: 20 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value=" View Suggested Books By id")
	@GetMapping(value="/ViewSuggestedBooksById/{id}")
	public SuggestedBooks getAllSuggestedBooksById(@PathVariable int id)
	{
		try {
		return suggestedBooksService.viewSuggestedBookDetails(id);
		}
		catch(BookNotFoundException e)
		{
			throw new BookNotFoundException("Enter Valid Id ");
		}
	}
	
}

