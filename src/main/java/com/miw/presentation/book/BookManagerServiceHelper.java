package com.miw.presentation.book;

import java.util.List;

import org.apache.logging.log4j.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miw.business.bookmanager.BookManagerService;
import com.miw.model.Book;

public class BookManagerServiceHelper {

	
	private static ApplicationContext context = null;
	Logger logger = LogManager.getLogger(this.getClass());	
	
	private ApplicationContext getContext()
	{
		if ( context == null )
		{
			context = 
		             new ClassPathXmlApplicationContext("beans.xml");
		}
		return context;
	}
	
	public List<Book> getBooks() throws Exception {
		logger.debug("Retrieving Books from Business Layer");
		//We load the service
		BookManagerService bms = (BookManagerService) getContext().getBean("bookManagerService");
		return bms.getBooks();		
	}

	public Book getSpecialOffer() throws Exception {
		logger.debug("Retrieving Special Offer from Business Layer");
		BookManagerService bms = (BookManagerService) getContext().getBean("bookManagerService");
		return bms.getSpecialOffer();
	}
	
}
