package com.capgemini.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.lms.dto.DamagedBooksDto;
import com.capgemini.lms.dto.SuggestedBooksDto;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.DamagedBooksService;
import com.capgemini.lms.service.SuggestedBooksService;

@SpringBootTest
class Sprint1lmsApplicationTests {

	@Autowired
	DamagedBooksService damagedBooksService;
	@Autowired
	SuggestedBooksService suggestedBooksService; 

    @Test
	void addDamagedBooksTest() 
    {
    	DamagedBooksDto damagedBooksDto= new DamagedBooksDto(13,"Binding Damage",1);
    	assertEquals(1,damagedBooksService.addDamagedBooks(damagedBooksDto).getId());
	}
    @Test
    void updateDamagedBooksDetailsTest()
      {
    	DamagedBooksDto damagedBooksDto= new DamagedBooksDto(4,"Double printed papers",6);
    	assertEquals("Double printed papers",damagedBooksService.updateDamagedBookDetails(damagedBooksDto).getDescription());
       }
    @Test
    void suggestBooksTest()
       {
    	SuggestedBooksDto suggestedBooksDto = new SuggestedBooksDto(1,"Basics of java","java","jamieson","sun","Good handbook",LocalDate.of(2021, 02, 12),"suggested",134);
    	assertEquals(1,suggestedBooksService.suggestBooks(suggestedBooksDto).getId());
       }
     @Test
     void updateSuggestedBooksTest()
    {
    	SuggestedBooksDto suggestedBooksDto = new SuggestedBooksDto(1,"Basics of java","java","jamieson","sun","Good handbook",LocalDate.of(2021, 02, 12),"suggested",134);
    	assertEquals(1,suggestedBooksService.suggestBooks(suggestedBooksDto).getId());
    }
    @Test
    void deleteByIdTest()
  {
    	SuggestedBooksDto suggestedBooksDto = new SuggestedBooksDto(1,"Basics of java","java","jamieson","sun","Good handbook",LocalDate.of(2021, 02, 12),"suggested",134);
    	suggestedBooksService.suggestBooks(suggestedBooksDto);
    	int id = suggestedBooksDto.getBookId();
    	suggestedBooksService.deleteSuggestedBooks(id);
         	assertThrows(BookNotFoundException.class,()->suggestedBooksService.viewSuggestedBooksList());
  }
////    
////    
}
