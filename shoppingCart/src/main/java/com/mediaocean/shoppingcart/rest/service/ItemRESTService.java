package com.mediaocean.shoppingcart.rest.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mediaocean.shopping.model.Item;

/**
 * @author Mubeen
 * 
 *         This service interface has the REST methods to actually add and view
 *         all the products/items into the system
 * 
 */
@Path("/")
@WebService(name = "itemService")
public interface ItemRESTService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("")
    public List<Item> getAllItems();

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("")
    public List<Item> addItems(List<Item> item);

}