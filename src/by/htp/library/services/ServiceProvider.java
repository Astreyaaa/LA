package by.htp.library.services;

import by.htp.library.implement2.ClientImplemept;
import by.htp.library.implement2.LibraryImplemept;
import by.htp.library.implement2.SearchImplemept;

public final class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private final ClientService clientService = new ClientImplemept();
	private final LibraryService libraryService = new LibraryImplemept();
	private final SearchService searchService = new SearchImplemept();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

}
