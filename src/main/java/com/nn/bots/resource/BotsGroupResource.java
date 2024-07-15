package com.nn.bots.resource;

import com.nn.bots.center.BotsCenter;
import com.nn.bots.center.BotsGroupCenter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.mamoe.mirai.contact.Group;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangxiao
 * @since V1.0.0 2024/07/15
 */
@Path("/bots/group")
public class BotsGroupResource {
    @Inject
    BotsGroupCenter botsGroupCenter;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Long> groups(@PathParam("id") Long id) {
        return botsGroupCenter.groups(id).stream().map(Group::getId).collect(Collectors.toList());
    }

    @Path("/{id}/{groupId}")
    public String group(@PathParam("id") Long id, @PathParam("groupId") Long groupId) {
        botsGroupCenter.attach(id, groupId);
        return "绑定成功";
    }
}
