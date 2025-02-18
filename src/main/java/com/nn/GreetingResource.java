package com.nn;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    @Inject
    GreetingConfig greetingConfig;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingConfig.message();
    }
}
