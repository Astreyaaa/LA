package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.exception.ExceptionsDAO;

public interface Search {

	List<Book> searchByGenre(String genre) throws ExceptionsDAO;

	List<Book> searchByTitle(String title) throws ExceptionsDAO;

	List<Book> searchByAuthor(String author) throws ExceptionsDAO;

}
