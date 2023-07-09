package org.acme;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.services.GreetingService;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Arrays;

@Path("/hello")
public class GreetingResource {

    @Inject
    Config config;

    @Inject
    GreetingService service;

    @ConfigProperty(name = "greeting.message")
    @Size(min = 4)
    String message;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "{" +
                "" + message + "} from RESTEasy Reactive";
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        config.getPropertyNames().forEach( p -> System.out.println(p));
        return config.getValue("greeting.message", String.class);
    }

    @GET
    @Path("/injecting")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloInjecting() {
        return service.getGreeting();
    }

}