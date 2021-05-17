package by.htp.library.controller.command.impl;

import by.htp.library.controller.Command;

public class Wrong implements Command {

	public String execute(String request) {

		return "Error";

	}

}
