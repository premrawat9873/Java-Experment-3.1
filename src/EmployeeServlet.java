package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

    // --- EDIT THESE CONSTANTS BEFORE BUILDING/DEPLOYING ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    private static final String DB_USER = "YOUR_DB_USERNAME";
    private static final String DB_PASS = "YOUR_DB_PASSWORD";
    // -------------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String empid = request.getParameter("empid");
            try (Connection con = getConnection()) {
                String query;
                if (empid != null && !empid.trim().isEmpty()) {
                    query = "SELECT * FROM Employee WHERE EmpID = ?";
                    try (PreparedStatement ps = con.prepareStatement(query)) {
                        ps.setInt(1, Integer.parseInt(empid.trim()));
                        try (ResultSet rs = ps.executeQuery()) {
                            printTable(rs, out);
                        }
                    }
                } else {
                    query = "SELECT * FROM Employee";
                    try (PreparedStatement ps = con.prepareStatement(query);
                         ResultSet rs = ps.executeQuery()) {
                        printTable(rs, out);
                    }
                }
            } catch (SQLException e) {
                out.println("<h3 style='color:red;'>Database error:</h3>");
                out.println("<pre>" + e.getMessage() + "</pre>");
            }
            out.println("<p><a href='employee.html'>Back</a></p>");
        }
    }

    private void printTable(ResultSet rs, PrintWriter out) throws SQLException {
        out.println("<h2>Employee Details</h2>");
        out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");
        boolean any = false;
        while (rs.next()) {
            any = true;
            out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>" +
                        rs.getString("Name") + "</td><td>" + rs.getDouble("Salary") + "</td></tr>");
        }
        if (!any) {
            out.println("<tr><td colspan='3'>No records found</td></tr>");
        }
        out.println("</table>");
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
