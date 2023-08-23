public class MovieManager {
    private Movie[] movies;
    private int limit;

    public MovieManager() {
        this(5);
    }

    public MovieManager(int limit) {
        this.limit = limit;
        movies = new Movie[0];
    }

    public void addMovie(Movie movie) {
        Movie[] newMovies = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}