package by.htp.la.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UserDAO{

	public String signIn(String login, String password) throws FileNotFoundException, IOException{

		File userDataSourse = new File("resources/Users.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(userDataSourse))){
			String data = null;		
		 	while ((data = reader.readLine()) != null) {
		 		if (user(data, login, password)) {
		 			return login;
		 		}
		 	}	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return login;
	}

	public boolean user(String userData, String login, String password) {

		String[] data;
		String loginTemp;
		String passwordTemp;

		data = userData.split("/");
		loginTemp = data[1];
		passwordTemp = data[2];

		if (login.equals(loginTemp) && password.equals(passwordTemp)) {
			return true;
		}else{
			return false;
		}

	}
}

