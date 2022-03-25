package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import requests.SortRequest;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddMethodServlet", value = "/AddMethodServlet")
public class AddMethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String speed = request.getParameter("speed");
        try {
            SortRequest sortRequest = new SortRequest();
            sortRequest.addSort(name, speed);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException | ServletException e) {
            request.setAttribute("ErrorCode", e.fillInStackTrace());
            request.setAttribute("ErrorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
