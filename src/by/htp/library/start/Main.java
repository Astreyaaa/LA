package by.htp.library.start;

import by.htp.library.controller.Controller;

public class Main {

	public static void main(String[] args) {

		String role = null;

		Controller controller = new Controller();
		role = controller.executeTask("sign_in login=astreya password=999");
		System.out.println("Hello, " + role);
		
		String addBook = controller.executeTask("Add_New author=Max Frei title=Crow on the bridge genre=novel year=2019 type=paper access=general access available=home");
		System.out.println(addBook);
		
		String deleteBook = controller.executeTask("Delete id=4");
		System.out.println(deleteBook);

		String searchByAuthor = controller.executeTask("Search_By_Author author=Max Frei");
		System.out.println(searchByAuthor);

		String searchByGenre = controller.executeTask("Search_By_Genre genre=education");
		System.out.println(searchByGenre);

		String searchByTitle = controller.executeTask("Search_Title title=Stranger");
		System.out.println(searchByTitle);
		
		String passToFriend = controller.executeTask("To_Friend title=Stranger friend=Igor Grom");
		System.out.println(passToFriend);

		String returnBook = controller.executeTask("Return title=Stranger");
		System.out.println(returnBook);
	}

}
