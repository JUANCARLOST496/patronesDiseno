
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.logging.log4j.*;

import com.miw.business.BookDataServiceHelper;
import com.miw.model.Book;

public class BookManager implements BookManagerService {
	Logger logger = LogManager.getLogger(this.getClass());

	public List<Book> getBooks() throws Exception {
		logger.debug("Asking for books");
		List<Book> books = (new BookDataServiceHelper()).getBooks();
		
		// We calculate the final price with the VAT value
		for (Book b : books) {
			b.setPrice(b.getBasePrice() * (1 + b.getVat().getValue()));
		}
		return books;
	}
}
