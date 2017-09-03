package com.vidasoft.magman.admin;

import com.vidasoft.magman.advertiser.AdvertiserDAO;
import com.vidasoft.magman.content.ArticleDAO;
import com.vidasoft.magman.content.CommentDAO;
import com.vidasoft.magman.model.*;
import com.vidasoft.magman.user.AuthorDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@ApplicationScoped
public class DataLoader {

    @Inject
    private AuthorDAO authorDAO;

    @Inject
    private ArticleDAO articleDAO;

    @Inject
    private CommentDAO commentDAO;

    @Inject
    private AdvertiserDAO advertiserDAO;

    @Transactional
    public void load() {
        /* Add a couple of authors */
        Author johnSmith = authorDAO.addAuthor(new Author("john", "smith", "John",
                "Smith", "john.smit@vida-soft.com", true, 2000));
        Author paulaChester = authorDAO.addAuthor(new Author("paula", "chester", "Paula",
                "Chester","paula.chester@vida-soft.com", false, 750));

        /* Add some articles */
        System.out.println("Add articles:");
        Article article1 = articleDAO.addArticle(new Article("Bulgarian JUGs 2015",
                "2015 is over and 2016 is a week old now. However, I can’t forget the past year, which happened to be the most active one for the Bulgarian JUG, where I happen to be one of the co-leads. And what a year it was! We had everything: seminar talks with local and foreign speakers, hands on labs, Adopt OpenJDK and Adopt a JSR hackathons, a code retreat and a big international conference. In this blog post I will briefly go through all the events that kept our community busy in 2015.",
                johnSmith, LocalDate.of(2016, Month.JANUARY, 6)));
        articleDAO.addArticle(new Article("Primitives in Generics",
                "In the Bulgarian JUG we had an event dedicated to trying out the OpenJDK Valhalla project’s achievements in the area of using primitive parameters of generics. Our colleague and blogger Mihail Stoynov already wrote about our workshop. I decided, though, to go in a little bit more details and explain the various aspects of the feature.",
                johnSmith, LocalDate.of(2015, Month.MARCH, 6)));
        articleDAO.addArticle(new Article("Top antipatterns to inspire and motivate your team",
                "I tried to make a short review of  some of the best soft skills antipatterns that I have met. The idea is not about mocking or not only about it.  Such epic failures of the art of managing people should be considered very carefully because of their importance in the process of building capable development team or at least finding the right place to work and devote to.",
                paulaChester, LocalDate.of(2013, Month.MARCH, 16)));

        /* Add comments to one of the articles */
        commentDAO.addCommentToArticle(article1.getId(), new Comment("Great job, everyone!",
                paulaChester, LocalDateTime.of(2016, Month.APRIL, 11, 12, 34)));
        commentDAO.addCommentToArticle(article1.getId(), new Comment("Thank you, Paula!",
                johnSmith, LocalDateTime.of(2016, Month.APRIL, 11, 14, 55)));

        /* Add a few advertisers */
        advertiserDAO.addAdvertiser(new Advertiser("Google", "http://www.google.com", "advertising@google.com", SponsorPackage.GOLD));
        advertiserDAO.addAdvertiser(new Advertiser("Red Hat", "http://www.redhat.com", "advertising@redhat.com", SponsorPackage.GOLD));
        advertiserDAO.addAdvertiser(new Advertiser("SAP", "http://www.sap.com", "advertising@sap.com", SponsorPackage.SILVER));
        advertiserDAO.addAdvertiser(new Advertiser("Oracle", "http://www.oracle.com", "advertising@oracle.com", SponsorPackage.BRONZE));
        advertiserDAO.addAdvertiser(new Advertiser("VIDA Software", "http://www.vida-soft.com", "advertising@vida-software.com", SponsorPackage.BRONZE));
    }
}
