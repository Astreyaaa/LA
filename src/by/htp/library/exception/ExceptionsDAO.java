package by.htp.library.exception;

public class ExceptionsDAO extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionsDAO() {
		super();
	}

	public ExceptionsDAO(String message) {
		super(message);
	}

	public ExceptionsDAO(ExceptionsDAO e) {
		super(e);
	}

	public ExceptionsDAO(String message, ExceptionsDAO e) {
		super(message, e);
	}

}
