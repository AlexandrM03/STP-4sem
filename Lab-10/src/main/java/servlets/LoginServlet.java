package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;
import requests.UserRequests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            UserRequests userRequests = new UserRequests();
            String role = userRequests.checkUser(login, password);
            if (!Objects.equals(role, "null")) {
                HttpSession session = request.getSession();
                User user = new User();
                user.setLogin(login);
                user.setRole(role);
                session.setAttribute("current_user", user);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Incorrect login or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException | ServletException e) {
            request.setAttribute("ErrorCode", e.fillInStackTrace());
            request.setAttribute("ErrorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
