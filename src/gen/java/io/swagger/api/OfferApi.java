package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OfferApiService;
import io.swagger.api.factories.OfferApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Offer;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/offer")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-09-24T13:09:22.776Z[GMT]")public class OfferApi  {
   private final OfferApiService delegate;

   public OfferApi(@Context ServletConfig servletContext) {
      OfferApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("OfferApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (OfferApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = OfferApiServiceFactory.getOfferApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    
    @Operation(summary = "Add a new offer for merchant", description = "", security = {
        @SecurityRequirement(name = "api_key")    }, tags={ "offer" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "401", description = "Not authenticated"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response addOffer(@Parameter(description = "Offer object that needs to be added or updated to the store" ,required=true) Offer body

,
@Parameter(description = "" ,required=true)@HeaderParam("api_key") String apiKey

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addOffer(body,apiKey,securityContext);
    }
    @DELETE
    @Path("/{offerId}")
    
    
    @Operation(summary = "Deletes a offer", description = "", security = {
        @SecurityRequirement(name = "api_key")    }, tags={ "offer" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "401", description = "Not authenticated"),
        
        @ApiResponse(responseCode = "404", description = "Offer not found") })
    public Response deleteOffer(
@Parameter(description = "" ,required=true)@HeaderParam("api_key") String apiKey

,@Parameter(description = "Offer id to delete",required=true) @PathParam("offerId") Long offerId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteOffer(apiKey,offerId,securityContext);
    }
    @GET
    @Path("/{offerId}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Find offer by ID", description = "Returns a single offer", security = {
        @SecurityRequirement(name = "api_key")    }, tags={ "offer" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Offer.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "401", description = "Not authenticated"),
        
        @ApiResponse(responseCode = "404", description = "Offer not found") })
    public Response getOfferById(
@Parameter(description = "" ,required=true)@HeaderParam("api_key") String apiKey

,@Parameter(description = "ID of offer to return",required=true) @PathParam("offerId") Long offerId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getOfferById(apiKey,offerId,securityContext);
    }
    @PUT
    
    
    
    @Operation(summary = "Update an existing offer", description = "", security = {
        @SecurityRequirement(name = "api_key")    }, tags={ "offer" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "401", description = "Not authenticated"),
        
        @ApiResponse(responseCode = "404", description = "Offer not found"),
        
        @ApiResponse(responseCode = "405", description = "Validation exception") })
    public Response updateOffer(@Parameter(description = "Offer object that needs to be added or updated to the store" ,required=true) Offer body

,
@Parameter(description = "" ,required=true)@HeaderParam("api_key") String apiKey

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateOffer(body,apiKey,securityContext);
    }
}
