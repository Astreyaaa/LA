package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.LibraryService;
import by.htp.library.services.ServiceProvider;

public class AddNew implements Command {

	public String execute(String request) {

		String response = null;
		String author = null;
		String title = null;
		String genre = null;
		String year = null;
		String type = null;
		String access = null;
		String available = null;

		author = request.substring(request.indexOf("author") + 7,
				request.indexOf("title") - 1);
		title = request.substring(request.indexOf("title") + 6,
				request.indexOf("genre") - 1);
		genre = request.substring(request.indexOf("genre") + 6,
				request.indexOf("year") - 1);
		year = request.substring(request.indexOf("year") + 17,
				request.indexOf("type") - 1);
		type = request.substring(request.indexOf("type") + 5,
				request.indexOf("access") - 1);
		access = request.substring(request.indexOf("access") + 12,
				request.indexOf("available") - 1);
		available = request.substring(request.indexOf("available") + 13);


		Book addedBook = new Book(author, title, genre, year, type, access, available);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getLibraryService();

		try {
			response = libraryService.addNewBook(addedBook);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return response;
	}

}
