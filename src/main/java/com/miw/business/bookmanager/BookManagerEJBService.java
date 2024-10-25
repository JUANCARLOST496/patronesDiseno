
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.logging.log4j.*;

import com.miw.model.Book;

public class BookManagerEJBService implements BookManagerService {
	Logger logger = LogManager.getLogger(this.getClass());

	public List<Book> getBooks() throws Exception {
		System.out.println("*** BookManagerEJBService.getBooks();");
		
		return new BookManager().getBooks();
	}
	
	public Book getSpecialOffer() throws Exception
	{
		System.out.println("*** BookManagerEJBService.getSpecialOffer();");
		return new BookManager().getSpecialOffer();
	}
}
