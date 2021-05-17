package by.htp.library.dao;

import by.htp.library.implement.FileBook;
import by.htp.library.implement.FileSearch;
import by.htp.library.implement.FileUser;

public final class Provider {

	private static final Provider instance = new Provider();
	private final Books fileBook = new FileBook();
	private final Users fileUser = new FileUser();
	private final Search fileSearch = new FileSearch();

	private Provider() {

	}

	public static Provider getInstance() {
		return instance;
	}

	public Books getFileBookImpl() {
		return fileBook;
	}

	public Users getFileUserImpl() {
		return fileUser;
	}

	public Search getFileSearchImpl() {
		return fileSearch;
	}
}
