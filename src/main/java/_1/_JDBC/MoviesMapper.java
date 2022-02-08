package _1._JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviesMapper {

	public static Movies map(ResultSet executeQuery) throws SQLException {

		int id = executeQuery.getInt("id");
		String movieName = executeQuery.getString("movie_name");
		String movieGenre = executeQuery.getString("movie_genre");
		String movieGenreAlternative = executeQuery.getString("movie_genre_alternative");
		int yearRelease = executeQuery.getInt("year_of_release");

		return new Movies(id, movieName, movieGenre, movieGenreAlternative, yearRelease);
	}

}
