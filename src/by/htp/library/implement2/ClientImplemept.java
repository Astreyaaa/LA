package by.htp.library.implement2;

import by.htp.library.dao.Provider;
import by.htp.library.dao.Users;
import by.htp.library.exception.ExceptionsDAO;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.ClientService;

public class ClientImplemept implements ClientService {

	public static Provider daoProvider = Provider.getInstance();
	public static Users userDAO = daoProvider.getFileUserImpl();

	public String signIn(String login, String password) throws ServiceException {

		String role = "undefined";

		try {

			role = userDAO.signIn(login, password);

		} catch (ExceptionsDAO e) {

			throw new ServiceException(e);
		}

		return role;

	}

}
