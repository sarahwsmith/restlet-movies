package movies2;

public class Movie {
    private String title;
    private int rating;
    private int id;

    public Movie() { }
    
    // overrides
    @Override
    public String toString() {
	return String.format("%2d: ", id) + title + " has a rating of " + rating + " out of ten.";
    }
    
    // properties
    public void setTitle(String title) { 
	this.title = title; 
    }

    public void setRating(int rating){
    this.rating = rating;
    }

    public String getTitle() { return this.title; }
    
    public int getRating() { return this.rating; }

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
}