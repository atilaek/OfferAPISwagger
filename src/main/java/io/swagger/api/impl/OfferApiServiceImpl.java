package io.swagger.api.impl;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.OfferApiService;
import io.swagger.api.repository.IOfferRepository;
import io.swagger.api.repository.impl.OfferRepository;
import io.swagger.api.util.ApiResourcesBundle;
import io.swagger.model.Offer;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-09-24T13:09:22.776Z[GMT]")
public class OfferApiServiceImpl extends OfferApiService {
    public static final ApiResourcesBundle API_RESOURCES_BUNDLE = new ApiResourcesBundle();
    public static final String API_KEY = API_RESOURCES_BUNDLE.getApiKey();

    private IOfferRepository offerRepository = new OfferRepository();

    @Override
    public Response addOffer(Offer offer, String apiKey, SecurityContext securityContext) throws NotFoundException {
        if (!apiKey.equals(API_KEY)) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not authenticated")).build();
        }
        if (offerRepository.hasOffer(offer)) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Offer " + offer + " already exists.")).build();
        }
        final int key = offerRepository.addOffer(offer);
        offerRepository.saveRepository();
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, String.valueOf(key))).build();
    }

    @Override
    public Response deleteOffer(String apiKey, Long offerId, SecurityContext securityContext) throws NotFoundException {
        if (!apiKey.equals(API_KEY)) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not authenticated")).build();
        }
        if (!offerRepository.containsKey(offerId.intValue())) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unable to find offer with id:" + offerId)).build();
        }
        offerRepository.deleteOffer(offerId.intValue());
        offerRepository.saveRepository();
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, String.valueOf(offerId))).build();
    }

    @Override
    public Response getOfferById(String apiKey, Long offerId, SecurityContext securityContext) throws NotFoundException {
        if (!apiKey.equals(API_KEY)) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not authenticated")).build();
        }
        if (!offerRepository.containsKey(offerId.intValue())) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unable to find offer with id:" + offerId)).build();
        }
        final Offer offer = offerRepository.getOffer(offerId.intValue());
        if (!offer.isCancelled()) {
            if (!offer.isOutdated()) {
                return Response.ok().entity(offerRepository.getOffer(offerId.intValue())).build();
            } else {
                offer.setCancelled(true);
            }
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Cancelled or outdated offers can not be shown!")).build();


    }

    @Override
    public Response updateOffer(Offer offer, String apiKey, SecurityContext securityContext) throws NotFoundException {
        if (!apiKey.equals(API_KEY)) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not authenticated")).build();
        }
        if (!offerRepository.containsKey(offer.getId().intValue())) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unable to find offer with id:" + offer.getId())).build();
        }
        offerRepository.updateOffer(offer.getId().intValue(), offer);
        offerRepository.saveRepository();
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, offer.getId().toString())).build();
    }
}
