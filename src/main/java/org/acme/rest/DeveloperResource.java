package org.acme.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

@Path("/api/developer")
public class DeveloperResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created(
                UriBuilder
                        .fromResource(DeveloperResource.class)
                        .path(Long.toString(developer.getId()))
                        .build()
        )
                .entity(developer)
                .build();
    }

    public static class Developer {
        static long counter = 1;
        private long id;
        private String name;
        public long getId() {
            return id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void persist() {
            this.id = counter++;
        }
    }

}
