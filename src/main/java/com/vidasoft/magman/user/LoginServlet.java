package com.vidasoft.magman.user;


import com.vidasoft.magman.admin.DataLoader;
import com.vidasoft.magman.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 5070928362318899898L;

    @Inject
    private DataLoader dataLoader;

    @Inject
    private UserDAO userDAO;

    @Inject
    private UserContext userContext;

    @Override
    public void init() throws ServletException {
        dataLoader.load();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("failed") != null) {
            req.setAttribute("message", "Login failed");
        }
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        Optional<User> user = userDAO.login(userName, password);
        user.ifPresent(userContext::setLoggedUser);

        resp.sendRedirect(user.map(loggedUser -> "ArticleServlet").orElse("LoginServlet?failed"));
    }
}
