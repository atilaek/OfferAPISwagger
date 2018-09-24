package io.swagger.api.factories;

import io.swagger.api.OfferApiService;
import io.swagger.api.impl.OfferApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-09-24T13:09:22.776Z[GMT]")public class OfferApiServiceFactory {
    private final static OfferApiService service = new OfferApiServiceImpl();

    public static OfferApiService getOfferApi() {
        return service;
    }
}
