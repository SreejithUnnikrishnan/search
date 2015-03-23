/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entity.SavedData;
import java.io.StringReader;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author c0644881
 */
@Path("/saved")
public class SavedDataServices {
    @EJB
    SavedData saved;

    @GET
    @Path("{place}")
    @Produces("application/json")
    public String getAll(@PathParam("place") String place) {
        String result = saved.getSavedData(place);
        return result;
    }

    @GET
    @Path("{place}/{type}")
    @Produces({"application/json"})
    public String getSpecific(@PathParam("place") String place, @PathParam("type") String type) {
        String result = saved.getsavedType(place, type);
        return result;
    }
    
    @POST
    //@Consumes("application/json")
    public String addData(String str){
        System.out.println("inside post of saved data...:" + str + ":asdfjashd");
        String value = str.substring(3);
        String result = saved.addData(value);
        return result;
    }
    
    @DELETE
    @Path("{id}")
    public String deleteSaved(@PathParam("id") String id){
        String result = saved.delete(id);
        return result;
    }
    
}
