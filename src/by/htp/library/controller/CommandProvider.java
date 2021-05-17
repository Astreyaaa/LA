package by.htp.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.library.controller.command.impl.AddNew;
import by.htp.library.controller.command.impl.Delete;
import by.htp.library.controller.command.impl.ToFriend;
import by.htp.library.controller.command.impl.Return;
import by.htp.library.controller.command.impl.SearchAuthor;
import by.htp.library.controller.command.impl.SearchGenre;
import by.htp.library.controller.command.impl.SearchTitle;
import by.htp.library.controller.command.impl.SingIn;
import by.htp.library.controller.command.impl.Wrong;

final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.SIGNIN, new SingIn());
		repository.put(CommandName.ADD_NEW, new AddNew());
		repository.put(CommandName.DELETE, new Delete());
		repository.put(CommandName.TO_FRIEND, new ToFriend());
		repository.put(CommandName.RETURN, new Return());
		repository.put(CommandName.SEARCH_AUTHOR, new SearchAuthor());
		repository.put(CommandName.SEARCH_GENRE, new SearchGenre());
		repository.put(CommandName.SEARCH_TITLE, new SearchTitle());
		repository.put(CommandName.WRONG, new Wrong());

	}

	Command getCommand(String name) {

		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG);
		}

		return command;
	}

}
