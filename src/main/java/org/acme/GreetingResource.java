package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Arrays;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "{" + message + "} from RESTEasy Reactive";
    }
}