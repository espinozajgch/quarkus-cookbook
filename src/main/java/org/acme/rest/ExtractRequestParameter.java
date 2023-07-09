package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/api/v1")
public class ExtractRequestParameter {

    public static enum Order {
        desc, asc;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @HeaderParam("authorization") String authorization)
    {
        return String.format("URI: %s - Order %s - Authorization: %s",
                uriInfo.getAbsolutePath(), order, authorization);
    }
}
