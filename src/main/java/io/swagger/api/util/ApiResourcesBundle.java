package io.swagger.api.util;

import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author Atila Ekimci
 */
public class ApiResourcesBundle {
    private final static String apikey = "api_key";

    private String bundleName;
    private ResourceBundle resourceBundle;

    public ApiResourcesBundle(final String bundleName) {
        resourceBundle = ResourceBundle.getBundle(bundleName);
    }

    @SuppressWarnings("unused")
    public ApiResourcesBundle() {
        resourceBundle = ResourceBundle.getBundle("apiResources");
    }

    public String getProperty(final String propertyId) {
        return resourceBundle.getString(propertyId);
    }

    public String getApiKey() {
        return getProperty(apikey);
    }
}
