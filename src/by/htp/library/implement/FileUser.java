package by.htp.library.implement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.htp.library.dao.Users;
import by.htp.library.exception.ExceptionsDAO;

public class FileUser implements Users {

	@Override
	public String signIn(String login, String password) throws ExceptionsDAO {

		File userDataSourse = new File("resources/User.txt");
		BufferedReader reader = null;

		String role = "undefined";

		try {
			reader = new BufferedReader(new FileReader(userDataSourse));
			String userData = null;

			while ((userData = reader.readLine()) != null) {

				if (findAuthUser(userData, login, password)) {
					role = role(userData);
					return role;
				}
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

		return role;

	}

	public boolean findAuthUser(String userData, String login, String password) {

		String[] arrayUserData;
		String tempLogin;
		String tempPassword;

		arrayUserData = userData.split("/");
		tempLogin = arrayUserData[1];
		tempPassword = arrayUserData[2];

		if (login.equals(tempLogin) && password.equals(tempPassword)) {
			return true;
		} else {
			return false;
		}

	}

	public String role(String userData) {

		String[] arrayUserData;
		String role;

		arrayUserData = userData.split("/");
		role = arrayUserData[3];

		return role;
	}

	public boolean findAuthBook(String bookData, String title) {

		String[] arrayUserData;
		String tempTitle;

		arrayUserData = bookData.split("/");
		tempTitle = arrayUserData[2];

		if (title.equals(tempTitle)) {
			return true;
		} else {
			return false;
		}

	}

}
