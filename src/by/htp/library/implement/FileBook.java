package by.htp.library.implement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.htp.library.bean.Book;
import by.htp.library.dao.Books;
import by.htp.library.exception.ExceptionsDAO;

public class FileBook implements Books {

	public void add(Book book) throws ExceptionsDAO {

		int newId;
		String newBookLine;

		String path = new File("resources/Books.txt").getAbsolutePath();
		File file = new File(path);
		FileWriter fr = null;

		newId = getID();
		newBookLine = createLineForNewBook(book, newId);

		try {
			fr = new FileWriter(file, true);
			fr.write(newBookLine);

		} catch (IOException e) {
			System.out.println("Add to file error");
			throw new ExceptionsDAO();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private int getID() {

		String path = new File("resources/Books.txt").getAbsolutePath();
		File booksDataSourse = new File(path);
		BufferedReader reader = null;

		String lastBook = "";
		int newId;

		try {

			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				lastBook = bookData;

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		newId = nubmerLine(lastBook) + 1;

		return newId;

	}

	private String createLineForNewBook(Book book, int id) {

		String newBookLine;

		newBookLine = id + "/" + book.getAuthor() + "/" + book.getTitle() + "/"
				+ book.getGenre() + "/" + book.getYear() + "/" + book.getType()
				+ "/" + book.getAccess() + "/" + book.getAvailable();

		return newBookLine;
	}

	@Override
	public void deleteBook(Book book) throws ExceptionsDAO {

		int id;
		String newContent;

		id = book.getid();

		String path = new File("resources/Books.txt").getAbsolutePath();
		File file = new File(path);

		try {

			newContent = getContent(id);
			toFile(file, newContent);

		} catch (IOException e) {
			System.out.println("Deleting error");
			throw new ExceptionsDAO();
		}
	}

	@Override
	public boolean toFriend(Book book, String friend) throws ExceptionsDAO {

		String path = new File("resources/Books.txt").getAbsolutePath();
		File booksDataSourse = new File(path);
		BufferedReader reader = null;
		String title = book.getTitle();

		try {

			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				if (findForFriend(bookData, title)) {

					if (newLocation(bookData)) {
						return false;
					} else {

						String bookGivenToFriend = changeLine(bookData, friend);

						int lineNumberToReplace = nubmerLine(bookGivenToFriend);

						String newContent = newLocation(bookGivenToFriend, lineNumberToReplace);

						toFile(booksDataSourse, newContent);

						return true;

					}

				}
			}

		} catch (IOException e) {
			System.out.println("File connection error");
			throw new ExceptionsDAO();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new ExceptionsDAO();
				}
			}
		}

		return false;
	}

	private boolean findForFriend(String bookData, String title) {

		String[] arrayBookData;
		String tempTitle;
		String tempType;
		String tempLocation;

		arrayBookData = bookData.split("/");

		tempTitle = arrayBookData[2];
		tempType = arrayBookData[5];
		tempLocation = arrayBookData[arrayBookData.length - 1];

		if (title.equals(tempTitle) && tempType.equals("paper") && tempLocation.equals("home")) {
			return true;
		} else {
			return false;
		}

	}

	private boolean findToReturn(String bookData, String title) {

		String[] arrayBookData;
		String tempTitle;
		String tempLocation;

		arrayBookData = bookData.split("/");

		tempTitle = arrayBookData[2];
		tempLocation = arrayBookData[arrayBookData.length - 1];

		if (title.equals(tempTitle) && !(tempLocation.equals("home"))) {
			return true;
		} else {
			return false;
		}

	}

	private boolean newLocation(String bookData) {

		String[] arrayBookData;

		String tempAccess;

		arrayBookData = bookData.split("/");
		tempAccess = arrayBookData[6];

		if (tempAccess.equals("no baby")) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean returnBook(String title) throws ExceptionsDAO {

		String path = new File("resources/Books.txt").getAbsolutePath();
		File booksDataSourse = new File(path);
		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				if (findToReturn(bookData, title)) {

					String returnedBook = changeLine(bookData, "home");

					int lineNumberToReplace = nubmerLine(returnedBook);

					String newContent = newLocation(returnedBook, lineNumberToReplace);

					toFile(booksDataSourse, newContent);

					return true;
				}

			}

		} catch (IOException e) {
			System.out.println("File connection error");
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new ExceptionsDAO();
				}
			}
		}

		return false;
	}

	private String changeLine(String bookData, String newLocation) {

		String[] arrayBookData;
		arrayBookData = bookData.split("/");

		StringBuffer tempBuffer = new StringBuffer();

		for (int i = 0; i < arrayBookData.length - 1; i++) {
			tempBuffer.append(arrayBookData[i]);
			tempBuffer.append("/");
		}

		tempBuffer.append(newLocation);

		String resultLine = tempBuffer.toString();

		return resultLine;

	}

	private int nubmerLine(String bookLine) {

		String numberOfLine;
		int arithmeticNumberOfLine;

		numberOfLine = bookLine.substring(0, bookLine.indexOf("/"));
		arithmeticNumberOfLine = Integer.parseInt(numberOfLine);

		return arithmeticNumberOfLine;

	}
	
	private void toFile(File file, String newContent) throws IOException {

		FileOutputStream fileOut = null;

		try {

			fileOut = new FileOutputStream(file);
			fileOut.write(newContent.getBytes());

		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					throw new IOException(e);
				}
			}
		}

	}

	private String getContent(int id) throws IOException {

		String path = new File("resources/Books.txt").getAbsolutePath();
		File booksDataSourse = new File(path);
		BufferedReader reader = null;

		StringBuffer bufferContent = new StringBuffer();

		try {

			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {
				int tempid = nubmerLine(bookData);
				if (tempid == id) {
					continue;
				} else {
					bufferContent.append(bookData).append("\n");
				}

			}

		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new IOException(e);
				}
			}
		}

		String content = bufferContent.toString();
		return content;

	}
	
	private String newLocation(String changingLine, int lineNumberToReplace) throws IOException {

		String path = new File("resources/Books.txt").getAbsolutePath();
		File booksDataSourse = new File(path);
		BufferedReader reader = null;

		StringBuffer bufferContent = new StringBuffer();

		try {

			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			int iter = 1;

			while ((bookData = reader.readLine()) != null) {

				if (iter == lineNumberToReplace) {
					bufferContent.append(changingLine).append("\n");
				} else {
					bufferContent.append(bookData).append("\n");
				}

				iter++;

			}

		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new IOException(e);
				}
			}
		}

		String content = bufferContent.toString();
		return content;

	}

}
