package com.miw.presentation.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miw.presentation.commands.Command;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/Controller") 
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected Logger logger = LogManager.getLogger(getClass());

	Command command = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// We execute the received command
		String action = req.getParameter("action");
		if (action != null) {
			logger.debug("Executing action" + action);

			command = ControllerConfigurationManager.getInstance().getCommand(action);
			
			// We execute the command and redirect
			if (command != null) {
				command.setRequest(req);
				command.setResponse(resp);
				command.execute();

				RequestDispatcher dispatcher = req
						.getRequestDispatcher(ControllerConfigurationManager.getInstance().getForward(action));
				dispatcher.forward(req, resp);
			}
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
