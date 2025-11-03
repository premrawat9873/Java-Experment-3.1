package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AttendanceServlet extends HttpServlet {

    // --- EDIT THESE CONSTANTS BEFORE BUILDING/DEPLOYING ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String DB_USER = "YOUR_DB_USERNAME";
    private static final String DB_PASS = "YOUR_DB_PASSWORD";
    // -------------------------------------------------------

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sid = request.getParameter("studentId");
            String date = request.getParameter("date");
            String status = request.getParameter("status");

            if (sid == null || sid.trim().isEmpty() || date == null || date.trim().isEmpty()) {
                out.println("<h3 style='color:red;'>Student ID and Date are required.</h3>");
                out.println("<p><a href='attendance.jsp'>Back</a></p>");
                return;
            }

            String sql = "INSERT INTO Attendance (StudentID, Date, Status) VALUES (?, ?, ?)";
            try (Connection con = getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, sid.trim());
                ps.setDate(2, Date.valueOf(date.trim()));
                ps.setString(3, status);
                int i = ps.executeUpdate();
                if (i > 0) {
                    response.sendRedirect("success.jsp");
                } else {
                    out.println("<h3 style='color:red;'>Failed to save attendance.</h3>");
                    out.println("<p><a href='attendance.jsp'>Back</a></p>");
                }
            } catch (SQLException e) {
                out.println("<h3 style='color:red;'>Database error:</h3>");
                out.println("<pre>" + e.getMessage() + "</pre>");
            }
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("MySQL JDBC driver not found", ex);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
