
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.logging.log4j.*;

import com.miw.model.Book;


public class BookManagerEJBService implements BookManagerService {
	Logger logger = LogManager.getLogger(this.getClass());
	
	private Integer repetitions = 1;

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

	public List<Book> getBooks() throws Exception {
		printMessage("*** BookManagerEJBService.getBooks();");
		return new BookManager().getBooks();
	}
	
	public Book getSpecialOffer() throws Exception
	{
		printMessage("*** BookManagerEJBService.getSpecialOffer();");
		return new BookManager().getSpecialOffer();
	}
	
	private void printMessage(String message )
	{
		for ( int i = 0 ; i < repetitions ; i ++ )
		{
			System.out.println(message);
		}
	}
}
