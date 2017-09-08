package com.vidasoft.magman.advertiser;

import com.vidasoft.magman.model.Advertiser;
import com.vidasoft.magman.model.SponsorPackage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AdvertiserProducer {

    @Inject
    private AdvertiserDAO advertiserDAO;

    @Gold
    @Produces
    public List<Advertiser> getGoldAdvertisers() {
        return advertiserDAO.findAdvertisersByPackage(SponsorPackage.GOLD);
    }

    @Silver
    @Produces
    public List<Advertiser> getSilverAdvertisers() {
        return advertiserDAO.findAdvertisersByPackage(SponsorPackage.SILVER);
    }

    @Bronze
    @Produces
    public List<Advertiser> getBronzeAdvertisers() {
        return advertiserDAO.findAdvertisersByPackage(SponsorPackage.BRONZE);
    }

}
