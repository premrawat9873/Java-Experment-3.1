package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    // NOTE: credentials are hardcoded for demo. Change as needed.
    private static final String DEMO_USER = "admin";
    private static final String DEMO_PASS = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");

            if (DEMO_USER.equals(user) && DEMO_PASS.equals(pass)) {
                out.println("<h2>Welcome, " + escapeHtml(user) + "!</h2>");
                out.println("<p>Login successful.</p>");
                out.println("<p><a href='index.html'>Home</a></p>");
            } else {
                out.println("<h3 style='color:red;'>Invalid Username or Password!</h3>");
                out.println("<a href='login.html'>Try Again</a>");
            }
        }
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replaceAll("&", "&amp;").replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll('"', '&quot;');
    }
}
