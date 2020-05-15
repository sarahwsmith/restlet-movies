package movies2;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.representation.Representation;
import org.restlet.ext.xml.DomRepresentation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.restlet.data.Status;
import org.restlet.data.MediaType;
import java.util.List;

public class XmlAllResource extends ServerResource {
    public XmlAllResource() { }

    @Get
    public Representation toXml() {
	List<Movie> list = Movies.getList();
	DomRepresentation dom = null;  
        try {  
            dom = new DomRepresentation(MediaType.TEXT_XML);  
	    dom.setIndenting(true);
            Document doc = dom.getDocument();  
  
            Element root = doc.createElement("movies");  
	    for (Movie movie : list) {
		Element next = doc.createElement("movie");  
		next.appendChild(doc.createTextNode(movie.toString()));  
		root.appendChild(next);
	    }
	    doc.appendChild(root);
	}
	catch(Exception e) { }
	return dom;
    }
}


