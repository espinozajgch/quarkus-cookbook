package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String
    hello() {

        int[] a = {1,2,3};
        String[] b = new String[5];
        int[] c = new int[10];
        Arrays.asList("1","2",3);

        return "Hello from RESTEasy Reactive";
    }
}