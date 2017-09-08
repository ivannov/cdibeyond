package com.vidasoft.magman.content;

import com.vidasoft.magman.advertiser.Gold;
import com.vidasoft.magman.model.Advertiser;
import com.vidasoft.magman.model.Article;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public abstract class ArticleContentDecorator implements ArticleDAO {

    @Inject
    @Delegate
    private ArticleDAO delegate;

    @Override
    public Optional<Article> findArticleById(Long id) {
        Optional<Article> article = delegate.findArticleById(id);
        return article.map(this::attachSponsorsToArticle);
    }

    private Article attachSponsorsToArticle(Article article) {
        String augmentedContent = article.getContent() +
                "<p>" + "<i>This article is supported by</i>: " + getGoldAdvertisersAsString();
        Article decoratedArticle = new Article(article.getTitle(), augmentedContent,
                article.getAuthor(), article.getPublishDate());
        decoratedArticle.setComments(article.getComments());
        return decoratedArticle;
    }

    @Inject
    @Gold
    private List<Advertiser> goldAdvertisers;

    private String getGoldAdvertisersAsString() {
        return goldAdvertisers.stream()
                .map(Advertiser::getName)
                .collect(Collectors.joining(", "));
    }
}
