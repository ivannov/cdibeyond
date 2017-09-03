package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Comment;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@RequestScoped
public class CommentDAO {

    @Inject
    private ArticleDAO articleDAO;

    @Transactional
    public Comment addCommentToArticle(Long articleId, Comment comment) {
        Optional<Article> article = articleDAO.findArticleById(articleId);
        article.ifPresent(a -> a.addComment(comment));
        return comment;
    }
}
