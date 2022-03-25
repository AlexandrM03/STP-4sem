package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import requests.UserRequests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            UserRequests userRequests = new UserRequests();
            if (Objects.equals(userRequests.checkUser(login, password), "null")) {
                userRequests.addUser(login, password);
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("message", "This user already registered");
                request.getRequestDispatcher("/registration.jsp").forward(request, response);
            }
        } catch (SQLException | ServletException e) {
            request.setAttribute("ErrorCode", e.fillInStackTrace());
            request.setAttribute("ErrorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
