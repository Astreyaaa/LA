package by.htp.library.controller.command.impl;

import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.LibraryService;
import by.htp.library.services.ServiceProvider;

public class Return implements Command {

	@Override
	public String execute(String request) {

		String response = null;
		String title = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryService();

		try {
			response = libraryService.returnBook(title);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return response;
	}

}
