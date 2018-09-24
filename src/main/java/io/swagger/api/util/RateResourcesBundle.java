package io.swagger.api.util;

import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author Atila Ekimci
 */
public class RateResourcesBundle {
    private final static String apikey = "api_key";

    private String bundleName;
    private ResourceBundle resourceBundle;

    public RateResourcesBundle(final String bundleName) {
        resourceBundle = ResourceBundle.getBundle(bundleName);
    }

    @SuppressWarnings("unused")
    public RateResourcesBundle() {
        resourceBundle = ResourceBundle.getBundle("apiResources");
    }

    public String getProperty(final String propertyId) {
        return resourceBundle.getString(propertyId);
    }

    public String getApiKey() {
        return getProperty(apikey);
    }
}
