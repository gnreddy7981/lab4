package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            response.sendRedirect(
                    request.getContextPath() + "/home"
            );

        } else {

            response.setContentType("text/html;charset=UTF-8");

            response.getWriter().println(
                    "<h2>Invalid Username or Password</h2>"
            );

            response.getWriter().println(
                    "<a href='" + request.getContextPath()
                            + "/login.html'>Try Again</a>"
            );
        }
    }
}