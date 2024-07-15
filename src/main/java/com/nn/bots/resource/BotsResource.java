package com.nn.bots.resource;

import com.nn.bots.center.BotsCenter;
import com.nn.bots.entity.LoginInfo;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import net.mamoe.mirai.Bot;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestQuery;

/**
 * @author yangxiao
 * @since V1.0.0 2024/07/15
 */
@Path("/bots")
public class BotsResource {
    @Inject
    BotsCenter botsCenter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Bot initBot(LoginInfo loginInfo) {
        return botsCenter.watchBot(loginInfo);
    }

    @Path("/login/{id}")
    @GET
    public String login(@PathParam("id") Long id) {
        botsCenter.login(id);
        return "登入成功";
    }
}
