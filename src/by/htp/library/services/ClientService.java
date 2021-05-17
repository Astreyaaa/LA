package by.htp.library.services;

import by.htp.library.exception2.ServiceException;

public interface ClientService {

	String signIn(String login, String password) throws ServiceException;

}
