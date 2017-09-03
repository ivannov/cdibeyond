package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ArticleServlet")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 4659806204473647796L;

    @Inject
    private ArticleDAO articleDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String articleId = req.getParameter("id");
        String forwardTo = articleId == null
                ? handleAllArticles(req)
                : handleSingleArticle(articleId, req);
        req.getRequestDispatcher(forwardTo).forward(req, resp);
    }
    private String handleAllArticles(HttpServletRequest req) throws ServletException, IOException {
        List<Article> articles = articleDAO.getAllArticles();
        req.setAttribute("articles", articles);
        return "jsp/viewArticles.jsp";
    }
    private String handleSingleArticle(String articleId, HttpServletRequest req) {
        Article article = articleDAO.findArticleById(Long.parseLong(articleId)).orElseThrow(IllegalArgumentException::new);
        req.setAttribute("article", article);
        return "jsp/viewArticle.jsp";
    }
}
