package com.dailyservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/test"
@Path("/test")
public class DummyResource {

    @GET // The Java method will process HTTP GET requests
    @Produces(value = "text/html") // The Java method will produce content identified by the MIME Media type "text/html"
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Welcome to DailyService!</body></h1></html>";
    }
}
