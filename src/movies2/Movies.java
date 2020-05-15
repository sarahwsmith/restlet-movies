package movies2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Movies {
    private static CopyOnWriteArrayList<Movie> movies;
    private static AtomicInteger id;

    static {
	String[ ] movieList = 
	    {"Titanic",
	     "The Matrix",
	     "The Big Lebowski",
	     "True Romance",
         "Pulp Fiction"};
    int[] ratingList = {8, 7, 10, 9, 9};

	movies = new CopyOnWriteArrayList<Movie>();
    id = new AtomicInteger();
    
    int index = 0; 
	for (String str : movieList) {
        add(str, ratingList[index]);
        index++;
    }
    }

    public static String toPlain() {
	String retval = "";
	int i = 1;
	for (Movie movie : movies) retval += movie.toString() + "\n";
	return retval;
    }
    
    public static CopyOnWriteArrayList<Movie> getList() { return movies; }

    // Support GET one operation.
    public static Movie find(int id) {
	Movie movie = null;
	for (Movie m : movies) {
	    if (m.getId() == id) {
		movie = m;
		break;
	    }
	}	
	return movie;
    }

    // Support POST operation.
    public static void add(String title, int rating) {
	int localId = id.incrementAndGet();
	Movie movie = new Movie();
    movie.setTitle(title);
    movie.setRating(rating);
	movie.setId(localId);
	movies.add(movie);
    }
}
