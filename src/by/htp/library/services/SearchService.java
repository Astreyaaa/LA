package by.htp.library.services;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.exception2.ServiceException;

public interface SearchService {

	List<Book> searchByGenre(String genre) throws ServiceException;

	List<Book> searchByTitle(String title) throws ServiceException;

	List<Book> searchByAuthor(String author) throws ServiceException;

}
