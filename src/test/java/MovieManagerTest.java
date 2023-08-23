import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("Movie 1");
        manager.addMovie(movie1);

        assertEquals(1, manager.findAll().length);
        assertEquals(movie1, manager.findAll()[0]);
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        assertEquals(2, manager.findAll().length);
        assertEquals(movie1, manager.findAll()[0]);
        assertEquals(movie2, manager.findAll()[1]);
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        Movie[] movies = new Movie[7];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = new Movie("Movie " + i);
            manager.addMovie(movies[i]);
        }

        Movie[] lastMovies = manager.findLast();
        assertEquals(5, lastMovies.length);
        assertEquals(movies[6], lastMovies[0]);
        assertEquals(movies[5], lastMovies[1]);
    }

    @Test
    public void testFindLastWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        Movie[] movies = new Movie[5];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = new Movie("Movie " + i);
            manager.addMovie(movies[i]);
        }

        Movie[] lastMovies = manager.findLast();
        assertEquals(3, lastMovies.length);
        assertEquals(movies[4], lastMovies[0]);
        assertEquals(movies[3], lastMovies[1]);
    }
}