package com.mediaocean.shoppingcart.rest.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mediaocean.shopping.model.ItemizedBill;

/**
 * @author Mubeen
 * 
 *         This service interface has the REST methods dealing with the Billing
 *         service to create a bill and add items to it and get a consolidated
 *         bill
 * 
 */
@Path("/")
@WebService(name = "billingService")
public interface BillingRESTService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("")
    public List<ItemizedBill> getAllBills();

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("")
    public String createBill();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/item/{itemId}")
    public ItemizedBill addBillItem(@PathParam("id") String billId, @PathParam("itemId") String itemId, @QueryParam("quantity") int quantity);

}