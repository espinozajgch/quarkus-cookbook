package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.util.Arrays;

@Path("/hello")
public class GreetingResource {

    private static Logger logger = Logger.getLogger(GreetingResource.class);

    @Inject
    Config config;

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        logger.info("hello");
        return "{" + message + "} from RESTEasy Reactive";
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        config.getPropertyNames().forEach( p -> System.out.println(p));
        return config.getValue("greeting.message", String.class);
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLog() {
        logger.info("I said Hello");
        return "hello";
    }
}