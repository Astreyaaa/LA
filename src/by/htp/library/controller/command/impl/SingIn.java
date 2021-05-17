package by.htp.library.controller.command.impl;

import by.htp.library.controller.Command;
import by.htp.library.exception2.ServiceException;
import by.htp.library.services.ClientService;
import by.htp.library.services.ServiceProvider;

public class SingIn implements Command {

	public String execute(String request) {

		String login;
		String password;
		String response = null;

		login = request.substring(request.indexOf("login") + 6, request.indexOf(' ', request.indexOf("login")));
		password = request.substring(request.indexOf("password") + 9);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientService();

		try {
			response = clientService.signIn(login, password);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return response;
	}

}
