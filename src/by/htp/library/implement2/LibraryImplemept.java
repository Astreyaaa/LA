package by.htp.library.implement2;

import by.htp.library.bean.Book;
import by.htp.library.dao.Books;
import by.htp.library.dao.Provider;
import by.htp.library.exception.ExceptionsDAO;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.LibraryService;

public class LibraryImplemept implements LibraryService {

	public static final Provider daoProvider = Provider.getInstance();
	public static final Books bookDAO = daoProvider.getFileBookImpl();

	@Override
	public String addNewBook(Book book) throws ServiceException {

		String response = "";

		try {

			bookDAO.add(book);
			response = "Added";

		} catch (ExceptionsDAO e) {
			throw new ServiceException(e);
		}

		return response;

	}

	@Override
	public String toFriend(Book book, String friend) throws ServiceException {

		String response = "";

		try {

			if (bookDAO.toFriend(book, friend)) {
				response = "Friend received book";
			} else {
				response = "Book is no home";
			}

		} catch (ExceptionsDAO e) {
			throw new ServiceException(e);
		}

		return response;

	}

	@Override
	public String returnBook(String title) throws ServiceException {

		String response = "";

		try {

			if (bookDAO.returnBook(title)) {
				response = "Returned";
			} else {
				response = "Book at home";
			}

		} catch (ExceptionsDAO e) {

			throw new ServiceException(e);
		}

		return response;

	}

	@Override
	public String delete(String id) throws ServiceException {

		int idBook = Integer.parseInt(id);
		
		Book book = new Book(idBook);
		
		String response = "";
		
		try {

			bookDAO.deleteBook(book);
			response = "Deleted";

		} catch (ExceptionsDAO e) {

			throw new ServiceException(e);
		}

		return response;
	}
	
	

}
