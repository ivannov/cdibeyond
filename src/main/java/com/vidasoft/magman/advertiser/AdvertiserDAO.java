package com.vidasoft.magman.advertiser;

import com.vidasoft.magman.model.Advertiser;
import com.vidasoft.magman.model.SponsorPackage;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class AdvertiserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Advertiser> findAdvertisersByPackage(SponsorPackage sponsorPackage) {
        TypedQuery<Advertiser> query = entityManager.createNamedQuery("findAdvertisersByPackage", Advertiser.class);
        query.setParameter("sponsorPackage", sponsorPackage);
        return query.getResultList();
    }

    @Transactional
    public Advertiser addAdvertiser(Advertiser advertiser) {
        entityManager.persist(advertiser);
        return advertiser;
    }
}