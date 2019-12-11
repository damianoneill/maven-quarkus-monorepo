package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The type Example resource.
 */
@Path("/hello")
public class ExampleResource {

    /**
     * Hello string.
     *
     * @return the string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello from orders";
    }
}
