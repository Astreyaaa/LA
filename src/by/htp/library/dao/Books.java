package by.htp.library.dao;

import by.htp.library.bean.Book;
import by.htp.library.exception.ExceptionsDAO;

public interface Books {

	void add(Book book) throws ExceptionsDAO;

	void deleteBook(Book book) throws ExceptionsDAO;

	boolean toFriend(Book book, String friend) throws ExceptionsDAO;

	boolean returnBook(String title) throws ExceptionsDAO;

}
