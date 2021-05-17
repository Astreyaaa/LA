package by.htp.library.controller.command.impl;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.SearchService;
import by.htp.library.services.ServiceProvider;

public class SearchAuthor implements Command {

	public String execute(String request) {

		String author = null;
		String response = "";

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		SearchService searchService = serviceProvider.getSearchService();

		try {

			List<Book> books = searchService.searchByAuthor(author);

			if (books.isEmpty()) {

				response = "No author";

			} else {

				System.out.println("Books:");
				for (Book book : books) {
					response = response + book.getAuthor() + " - " + book.getTitle() + " - " + book.getGenre()
							+ " - " + book.getYear() + " - " + book.getType() + " - "
							+ book.getAccess() + " - " + book.getAvailable();
				}

			}

		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return response;
	}

}
