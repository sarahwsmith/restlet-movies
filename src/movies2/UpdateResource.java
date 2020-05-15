package movies2;

import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.data.Status;
import org.restlet.data.MediaType;
import org.restlet.data.Form;

public class UpdateResource extends ServerResource {
    public UpdateResource() { }

    @Put
    public Representation update(Representation data) {
	Status status = null;
	String msg = null;

	// Extract the data from the POST body.
	Form form = new Form(data);
	String sid = form.getFirstValue("id");
	String title = form.getFirstValue("title");
	String srating = form.getFirstValue("rating");

	if (sid == null || title == null || srating == null) {
	    msg = "An ID, title, and rating must be provided.\n";
	    status = Status.CLIENT_ERROR_BAD_REQUEST;
	}
	else {
		int id = Integer.parseInt(sid.trim());
		int rating = Integer.parseInt(srating.trim());
	    Movie movie = Movies.find(id);
	    if (movie == null) {
		msg = "There is no movie with ID " + id + "\n";
		status = Status.CLIENT_ERROR_BAD_REQUEST;
	    }
	    else {
		movie.setTitle(title);
		movie.setRating(rating);
		msg = "Movie " + id + " has been updated to '" + title + "' with rating " + rating + ".\n";
		status = Status.SUCCESS_OK;
	    }
	}

	setStatus(status);
	return new StringRepresentation(msg, MediaType.TEXT_PLAIN);
    }
}


