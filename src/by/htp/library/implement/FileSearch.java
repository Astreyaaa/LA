package by.htp.library.implement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.Search;
import by.htp.library.exception.ExceptionsDAO;

public class FileSearch implements Search {

	public List<Book> searchByGenre(String genre) throws ExceptionsDAO {

		File booksDataSourse = new File("resources/Books.txt");
		BufferedReader reader = null;

		List<Book> books = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				String[] arrayBookData = findSuitableBooksByGenre(bookData, genre);
				if (arrayBookData == null) {
					continue;

				} else {
					books.add(new Book(arrayBookData[1], arrayBookData[2],
							arrayBookData[3], arrayBookData[4],
							arrayBookData[5], arrayBookData[6],
							arrayBookData[7]));
				}
			}

			if (books.isEmpty()) {
				return books = Collections.emptyList();
			} else {
				return books;
			}

		} catch (IOException e) {
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

	}

	public List<Book> searchByTitle(String title) throws ExceptionsDAO {

		File booksDataSourse = new File("resources/Books.txt");
		BufferedReader reader = null;

		List<Book> books = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				String[] arrayBookData = findSuitableBooksByTitle(bookData, title);
				if (arrayBookData == null) {
					continue;

				} else {
					books.add(new Book(arrayBookData[1], arrayBookData[2],
							arrayBookData[3], arrayBookData[4],
							arrayBookData[5], arrayBookData[6],
							arrayBookData[7]));
				}
			}

			if (books.isEmpty()) {
				return books = Collections.emptyList();
			} else {
				return books;
			}

		} catch (IOException e) {
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

	}

	public List<Book> searchByAuthor(String author) throws ExceptionsDAO {

		File booksDataSourse = new File("resources/Books.txt");
		BufferedReader reader = null;

		List<Book> books = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(booksDataSourse));
			String bookData = null;

			while ((bookData = reader.readLine()) != null) {

				String[] arrayBookData = findSuitableBooksByAuthor(bookData, author);

				if (arrayBookData == null) {
					continue;

				} else {

					books.add(new Book(arrayBookData[1], arrayBookData[2],
							arrayBookData[3], arrayBookData[4],
							arrayBookData[5], arrayBookData[6],
							arrayBookData[7]));
				}
			}

			if (books.isEmpty()) {
				return books = Collections.emptyList();
			} else {
				return books;
			}

		} catch (IOException e) {
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

	}

	private String[] findSuitableBooksByAuthor(String bookData, String author) {

		String[] arrayBookData;
		String temp;

		arrayBookData = bookData.split(";");
		temp = arrayBookData[1];

		if (author.equals(temp)) {
			return arrayBookData;
		} else {
			return null;
		}

	}

	private String[] findSuitableBooksByGenre(String bookData, String genre) {

		String[] arrayBookData;
		String temp;

		arrayBookData = bookData.split(";");
		temp = arrayBookData[3];

		if (genre.equals(temp)) {
			return arrayBookData;
		} else {
			return null;
		}

	}

	private String[] findSuitableBooksByTitle(String bookData, String title) {

		String[] arrayBookData;
		String temp;

		arrayBookData = bookData.split(";");
		temp = arrayBookData[2];

		if (title.equals(temp)) {
			return arrayBookData;
		} else {
			return null;
		}

	}

}
