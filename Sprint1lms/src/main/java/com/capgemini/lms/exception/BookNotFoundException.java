package com.capgemini.lms.exception;
/*********************************************************************************
 * 
 * @author SriHarika
 * Description: This class is used for handling BookNotFoundException
 * Version: v1.1
 * Created date: 22 April 2021
 *
 **********************************************************************************/
public class BookNotFoundException extends RuntimeException{


	public BookNotFoundException() {
		
	}
	
	public BookNotFoundException(String msg) {
		super(msg);
	}

}