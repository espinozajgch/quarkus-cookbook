package org.acme;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
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

    @GET
    @Path("/secured")
    @RolesAllowed("Tester")
    public String greetingSecured() {
        return "Secured";
    }

    @GET
    @Path("/unsecured")
    @PermitAll
    public String greetingUnsecured() {
        return "Unsecured";
    }

    @GET
    @Path("/denied")
    @DenyAll
    public String greetingDenied() {
        return "Denied";
    }

    @GET
    @Path("/authenticated")
    @Authenticated
    public String greetingAuthenticated() {
        return "Authenticated";
    }


}