package _1._JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {

	private static String READ_ALL = "select * from movies_db.movies";
	private static String CREATE = "insert into movies_db.movies (movie_name, movie_genre, movie_genre_alternative, year_of_release) values (?, ?, ?, ?)";
	private static String READ_BY_GENRE = "select * from movies_db.movies where movie_genre = ? or movie_genre_alternative = ?";
	private static String UPDATE_BY_ID = "update movies_db.movies set movie_name = ?, movie_genre = ?, movie_genre_alternative = ?, year_of_release = ? where id = ?";
	private static String DELETE_BY_ID = "delete from movies_db.movies where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public MoviesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Movies movies) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, movies.getMovieName());
		preparedStatement.setString(2, movies.getMovieGenre());
		preparedStatement.setString(3, movies.getMovieGenreAlternative());
		preparedStatement.setInt(4, movies.getYearRelease());
		preparedStatement.executeUpdate();
	}
	
	public List<Movies> read(String movieGenre, String movieGenreAlternative) throws SQLException {
		List<Movies> listOfMovies = new ArrayList<Movies>();
		preparedStatement = connection.prepareStatement(READ_BY_GENRE);
		preparedStatement.setString(1, movieGenre);
		preparedStatement.setString(2, movieGenreAlternative);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfMovies.add(MoviesMapper.map(result));
		}
		return listOfMovies;
	}
	
	public void update(Movies movies) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, movies.getMovieName());
		preparedStatement.setString(2, movies.getMovieGenre());
		preparedStatement.setString(3, movies.getMovieGenreAlternative());
		preparedStatement.setInt(4, movies.getYearRelease());
		preparedStatement.setInt(5, movies.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Movies> readAll() throws SQLException {
		List<Movies> listOfMovies = new ArrayList<Movies>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfMovies.add(MoviesMapper.map(result));
		}
		return listOfMovies;
	}
}
