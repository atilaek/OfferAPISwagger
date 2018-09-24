package io.swagger.api.repository.impl;

import io.swagger.api.repository.JsonReadWriter;
import io.swagger.api.repository.IOfferRepository;
import io.swagger.model.Offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Repository of Offers that mainly reads from Json and has core functions.
 *
 * @author Atila Ekimci
 */
public class OfferRepository implements IOfferRepository {

    private Map<Integer, Offer> offers = new HashMap<>();

    /**
     * Offer Repository Constructor.
     * Calls @{@link JsonReadWriter} to read the file
     * And puts offers in an ID mapped Map @{@link Map}.
     */
    public OfferRepository() {

        List<Offer> listOffers =  JsonReadWriter.readJsonFile();

        for (int i = 0; i < listOffers.size(); i++) {
            Offer offer = listOffers.get(i);
            offers.put(offer.getId().intValue(), offer);
        }
    }

    public boolean containsKey(final int id) {
        return offers.containsKey(id);
    }

    public Offer getOffer(final int id) {
        return offers.get(id);
    }

    public Map<Integer, Offer> getAllOffers() {
        return offers;
    }

    public boolean hasOffer(final Offer offer) {
        return offers.containsValue(offer);
    }

    /**
     * Adds a new offer with a new id to the list.
     *
     * @param newOffer @{@link Offer} the new offer to add.
     * @return @int the id of the new offer.
     */
    public int addOffer(final Offer newOffer) {
        Long key = Long.valueOf(offers.size()) + 1;
        newOffer.setId(key);
        offers.put(key.intValue(), newOffer);
        return key.intValue();
    }

    public int updateOffer(final int id, final Offer newOffer) {
        offers.put(id, newOffer);
        return id;
    }

    public int deleteOffer(final int id) {
        offers.remove(id);
        return id;
    }

    public void saveRepository() {
        JsonReadWriter.writeToJsonFile((Set)offers.values());
    }

}
