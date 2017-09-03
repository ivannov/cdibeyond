package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;
import com.vidasoft.magman.user.UserContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/NewArticleServlet")
public class    NewArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 4172390158136633197L;

    @Inject
    private ArticleDAO articleDAO;

    @Inject
    private UserContext userContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/newArticle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        articleDAO.addArticle(new Article(title, content,
                (Author) userContext.getLoggedUser(), LocalDate.now()));

        resp.sendRedirect("ArticleServlet");
    }
}
