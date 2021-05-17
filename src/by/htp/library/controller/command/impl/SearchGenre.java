package by.htp.library.controller.command.impl;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.SearchService;
import by.htp.library.services.ServiceProvider;

public class SearchGenre implements Command {

	public String execute(String request) {

		String genre = null;
		String response = "";

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		SearchService searchService = serviceProvider.getSearchService();

		try {

			List<Book> books = searchService.searchByGenre(genre);

			if (books.isEmpty()) {

				response = "No books";

			} else {

				System.out.println("Books");
				for (Book book : books) {
					response = response + book.getAuthor() + " - " + book.getTitle() + " - " + book.getGenre()
							+ " - " + book.getYear() + " - " + book.getType() + " - "
							+ book.getAccess() + " - " + book.getAvailable() + "\n";
				}

			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return response;
	}

}
