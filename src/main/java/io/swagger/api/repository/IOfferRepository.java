package io.swagger.api.repository;

import io.swagger.model.Offer;

/**
 * Interface for OfferRepository.
 *
 * @author Atila Ekimci
 */
public interface IOfferRepository {

    boolean containsKey(final int id);

    Offer getOffer(final int id);

    boolean hasOffer(final Offer offer);

    int addOffer(final Offer newOffer);

    int updateOffer(final int id, final Offer newOffer);

    int deleteOffer(final int id);

    void saveRepository();

}
