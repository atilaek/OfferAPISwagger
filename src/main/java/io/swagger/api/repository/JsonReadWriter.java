package io.swagger.api.repository;

import io.swagger.model.Offer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Class for json file reading.
 *
 * @author Atila Ekimci
 */
public class JsonReadWriter {

    private static final String fileName = "./offers_data.json";

    /**
     * Reads Json file through the static file path and put them in a @{@link Set<Offer> } object.
     *
     * @return @{@link Set<Offer>}
     */
    public static List<Offer> readJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        List<Offer> offers = null;
        try {
            File file = new File(fileName);
            // Convert JSON string from file to Object
            offers = Arrays.asList(mapper.readValue(file, Offer[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return offers;
    }

    /**
     * Gets @{@link Set<Offer> offers} object and writes to Json file through the static file path.
     *
     * @param offers Data object that has the list of offers
     */
    public static void writeToJsonFile(Set<Offer> offers) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Convert JSON string from file to Object
            mapper.writeValue(new File(fileName), offers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
