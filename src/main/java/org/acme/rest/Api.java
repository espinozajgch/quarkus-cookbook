package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Path("/api")
public class Api {

    final static Logger LOGGER = Logger.getLogger(Api.class);

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String message) {
        LOGGER.info("Create");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String read() {
        LOGGER.info("Read");
        return "Read";
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        LOGGER.info("Update");
        return message;
    }

    @DELETE
    public void delete() {
        LOGGER.info("Delete");
    }
}