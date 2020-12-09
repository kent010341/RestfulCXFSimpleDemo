/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfulcxfwithoutspring;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kent_chen
 */
@Path("request")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ObjectResource {
    
    @GET
    public String getTools() {
        return "GET request";
    }
    
    @GET
    @Path("/{toolId}")
    public String getTool(@PathParam("toolId") int id) {
        return "GET request with id " + id;
    }
    
    @POST
    public Response addTool(String str) {
        String opt = "POST request, accept string: " + str;
                
        return Response.status(Response.Status.CREATED)
                       .entity(opt)
                       .build();
    }
    
}
