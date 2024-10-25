package com.miw.presentation.commands;

import jakarta.servlet.http.HttpServletRequest;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.miw.presentation.di.ServletRequestAware;

public class ShowSpecialOfferCommand implements Command, ServletRequestAware {
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
}
