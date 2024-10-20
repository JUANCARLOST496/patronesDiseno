package com.miw.presentation.commands;

import com.miw.presentation.book.BookManagerServiceHelper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowSpecialOfferCommand implements Command {
	private HttpServletRequest request;
	
	public ShowSpecialOfferCommand( )
	{
	}
	
	public void execute()
	{
		logger.debug("Executing "+this.getClass().getName());
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			request.setAttribute("book", helper.getSpecialOffer());
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
