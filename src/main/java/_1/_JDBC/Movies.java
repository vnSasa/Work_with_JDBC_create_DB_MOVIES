package _1._JDBC;

public class Movies {

	private int id;
	private String movieName;
	private String movieGenre;
	private String movieGenreAlternative;
	private int yearRelease;

	public Movies(int id, String movieName, String movieGenre, String movieGenreAlternative, int yearRelease) {
		this.id = id;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieGenreAlternative = movieGenreAlternative;
		this.yearRelease = yearRelease;
	}

	public Movies(String movieName, String movieGenre, String movieGenreAlternative, int yearRelease) {
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieGenreAlternative = movieGenreAlternative;
		this.yearRelease = yearRelease;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieGenreAlternative() {
		return movieGenreAlternative;
	}

	public void setMovieGenreAlternative(String movieGenreAlternative) {
		this.movieGenreAlternative = movieGenreAlternative;
	}

	public int getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(int yearRelease) {
		this.yearRelease = yearRelease;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieGenreAlternative=" + movieGenreAlternative + ", yearRelease=" + yearRelease + "]";
	}

}
