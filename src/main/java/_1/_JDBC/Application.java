package _1._JDBC;

import java.awt.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		System.out.println("WELLCOME TO MENU");
		menu();

	}

	static void menu() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		MoviesDAO dao = new MoviesDAO(ConnectionUtil.openConnection());
		System.out.println(
				"**********************\nMAKE YOUR CHOICE\n_READALL_ _READbyGENRE_ _INSERT_ _UPDATE_ _DELETE_\n**************************");

		Scanner sc = new Scanner(System.in);
		String command = sc.next();

// CREATE
		
		if (command.equalsIgnoreCase("CREATE")) {
			List<Movies> listOfmovies = new ArrayList<>();

			System.out.println("enter the movie name(No Probils '_'): ");
			String movieName = sc.next();
			System.out.println("enter genre: ");
			String movieGenre = sc.next();
			System.out.println("enter alternative genre: ");
			String movieGenreAlternative = sc.next();
			System.out.println("enter year of release: ");
			int yearRelease = sc.nextInt();

			listOfmovies.add(new Movies(movieName, movieGenre, movieGenreAlternative, yearRelease));

			listOfmovies.forEach(moviesNew -> {
				try {
					dao.insert(moviesNew);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			
			
			menu();
		} 
		
// READ BY GENRE
		
		else if (command.equalsIgnoreCase("READbyGENRE")) {
			System.out.println("enter the movie genre: ");
			String movieGenre = sc.next();
			System.out.println("enter the movie alternative genre: ");
			String movieGenreAlternative = sc.next();
			dao.read(movieGenre, movieGenreAlternative).stream().forEach(System.out::println);
			menu();
		} 
		
//	READ ALL
		
		else if (command.equalsIgnoreCase("READAll")) {
			dao.readAll().stream().forEach(System.out::println);
			menu();
		} 
		
//	UPDATE
		
		else if (command.equalsIgnoreCase("UPDATE")) {
			List<Movies> listOfmovies = new ArrayList<>();

			System.out.println("enter the movie name(No Probils '_'): ");
			String movieName = sc.next();
			System.out.println("enter genre: ");
			String movieGenre = sc.next();
			System.out.println("enter alternative genre: ");
			String movieGenreAlternative = sc.next();
			System.out.println("enter year of release: ");
			int yearRelease = sc.nextInt();
			System.out.println("enter id");
			int id = sc.nextInt();

			listOfmovies.add(new Movies(id, movieName, movieGenre, movieGenreAlternative, yearRelease));

			listOfmovies.forEach(moviesNew -> {
				try {
					dao.update(moviesNew);
					;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			menu();
		} 
		
//	DELETE
		
		else if (command.equalsIgnoreCase("DELETE")) {
			System.out.println("enter id to delete: ");
			int id = sc.nextInt();
			dao.delete(id);
		} 
		
//	EXIT
		
		else if (command.equalsIgnoreCase("EXIT")) {
			System.exit(0);
		}
	}
}
