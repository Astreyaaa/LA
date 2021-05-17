package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.LibraryService;
import by.htp.library.services.ServiceProvider;

public class ToFriend implements Command {

	public String execute(String request) {

		String response = null;
		String title = null;
		String friend = null;

		Book bookForFriend = new Book(title);
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryService();

		try {
			response = libraryService.toFriend(bookForFriend, friend);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return response;
	}

}
