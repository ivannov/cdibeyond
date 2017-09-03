package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;

import java.util.List;
import java.util.Optional;

public interface ArticleDAO {

    List<Article> getAllArticles();

    Optional<Article> findArticleById(Long id);

    List<Article> findArticlesByAuthor(Author author);

    Article addArticle(Article newArticle);
}
