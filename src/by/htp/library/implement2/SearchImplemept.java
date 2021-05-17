package by.htp.library.implement2;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.Provider;
import by.htp.library.dao.Search;
import by.htp.library.exception.ExceptionsDAO;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.SearchService;

public class SearchImplemept implements SearchService {

	public List<Book> searchByGenre(String genre) throws ServiceException {

		Provider daoProvider = Provider.getInstance();
		Search searchDAO = daoProvider.getFileSearchImpl();

		List <Book> books;

		try {
			books = searchDAO.searchByGenre(genre);
		} catch (ExceptionsDAO e) {
			throw new ServiceException(e);
		}

		return books;
	}

	public List<Book> searchByTitle(String title) throws ServiceException {

		Provider daoProvider = Provider.getInstance();
		Search searchDAO = daoProvider.getFileSearchImpl();

		List <Book> books;

		try {
			books = searchDAO.searchByTitle(title);
		} catch (ExceptionsDAO e) {

			throw new ServiceException(e);
		}

		return books;
	}

	public List<Book> searchByAuthor(String author) throws ServiceException {

		Provider daoProvider = Provider.getInstance();
		Search searchDAO = daoProvider.getFileSearchImpl();

		List <Book> books;

		try {
			books = searchDAO.searchByAuthor(author);
		} catch (ExceptionsDAO e) {
			throw new ServiceException(e);
		}

		return books;
	}

}
