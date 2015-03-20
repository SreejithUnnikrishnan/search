/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.SearchData;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author c0644881
 */
@Path("/search")
public class SearchDataServices {

    @EJB
    SearchData search;

    @GET
    @Path("{place}")
    @Produces("application/json")
    public String getAll(@PathParam("place") String place) {
        String result = search.getSearchData(place);
        return result;
    }

    @GET
    @Path("{place}/{type}")
    @Produces({"application/json"})
    public String getSpecific(@PathParam("place") String place, @PathParam("type") String type) {
        String result = search.getSearchType(place, type);
        return result;
    }

}
