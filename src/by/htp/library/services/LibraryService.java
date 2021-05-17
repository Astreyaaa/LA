package by.htp.library.services;

import by.htp.library.bean.Book;
import by.htp.library.exception2.ServiceException;

public interface LibraryService {
	
	String addNewBook(Book book) throws ServiceException;
	
	String toFriend(Book book, String friend) throws ServiceException;

	String returnBook(String title) throws ServiceException;

	String delete(String id) throws ServiceException; 

}
