package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Offer;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-09-24T13:09:22.776Z[GMT]")public abstract class OfferApiService {
    public abstract Response addOffer(Offer body,String apiKey,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteOffer(String apiKey,Long offerId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getOfferById(String apiKey,Long offerId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateOffer(Offer body,String apiKey,SecurityContext securityContext) throws NotFoundException;
}
