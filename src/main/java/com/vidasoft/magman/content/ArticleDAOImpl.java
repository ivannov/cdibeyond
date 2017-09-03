package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class ArticleDAOImpl implements ArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        TypedQuery<Article> articleQuery = entityManager.createNamedQuery("getAllArticles", Article.class);
        return articleQuery.getResultList();
    }

    @Transactional
    @Override
    public Optional<Article> findArticleById(Long id) {
        Optional<Article> article = Optional.ofNullable(entityManager.find(Article.class, id));
        article.ifPresent(a -> a.getComments().size());
        return article;
    }

    @Override
    public List<Article> findArticlesByAuthor(Author author) {
        entityManager.merge(author);
        TypedQuery<Article> query = entityManager.createNamedQuery("findArticlesByAuthor", Article.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Article addArticle(Article newArticle) {
        entityManager.persist(newArticle);
        return newArticle;
    }
}
