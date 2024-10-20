package com.miw.presentation.commands;

import com.miw.presentation.book.BookManagerServiceHelper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowBooksCommand implements Command {
	private HttpServletRequest request;
	
	public ShowBooksCommand( )
	{
	}
	
	public void execute()
	{
		logger.debug("Executing ShowBooksCommand");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			request.setAttribute("books", helper.getBooks());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setResponse(HttpServletResponse response) {
	}

	public void setRequest(HttpServletRequest request) {
		this.request=request;		
	}
}
