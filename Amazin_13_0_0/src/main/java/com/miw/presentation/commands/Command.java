package com.miw.presentation.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
	Logger logger = LogManager.getLogger(Command.class);

	public abstract void execute();
	public abstract void setResponse(HttpServletResponse response);
	public abstract void setRequest(HttpServletRequest request);
}