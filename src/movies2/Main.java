package movies2;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {
    public static void main(String[ ] args) throws Exception {  
	// Create a new Component.  
	Component component = new Component();  
	
	// Add a new HTTP server listening on port 8182.  
	component.getServers().add(Protocol.HTTP, 8182);  
	
	// Attach the application.  
	component.getDefaultHost().attach("/movies", new MoviesApplication());  
	
	// Start the web server.  
	component.start();  
    }          
}
