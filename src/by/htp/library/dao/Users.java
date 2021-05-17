package by.htp.library.dao;

import by.htp.library.exception.ExceptionsDAO;

public interface Users {

	String signIn(String login, String password) throws ExceptionsDAO;
	
}
