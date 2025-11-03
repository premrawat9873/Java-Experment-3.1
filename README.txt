INSTRUCTIONS - WebApp

1) Overview
 - This archive contains a small Java web application using Servlets, JSP, and JDBC.
 - Place the WebContent folder contents as your webapp (or build into a WAR).
 - Java source files are under src/ and use package com.example.servlets.

2) Database credentials
 - The Java servlets (EmployeeServlet.java and AttendanceServlet.java) include placeholders:
    DB_USER = "YOUR_DB_USERNAME"
    DB_PASS = "YOUR_DB_PASSWORD"
   Replace these with your actual MySQL credentials before compiling.

 - JDBC URL defaults:
    EmployeeServlet -> jdbc:mysql://localhost:3306/company
    AttendanceServlet -> jdbc:mysql://localhost:3306/school

3) SQL scripts
 - sql/company.sql creates the company DB and Employee table with sample data.
 - sql/school.sql creates the school DB and Attendance table with a sample row.
 - Import them into MySQL (e.g., using MySQL Workbench or command line):
     mysql -u root -p < company.sql
     mysql -u root -p < school.sql

4) Build & Deploy
 - Option A: Use an IDE (Eclipse/IntelliJ)
    - Create a Dynamic Web Project (or Jakarta webapp) and copy WebContent into the webapp folder.
    - Put Java files into src (package: com.example.servlets).
    - Add MySQL JDBC driver (mysql-connector-java) to project libraries.
    - Build and export WAR. Deploy to Tomcat/Nimbus.

 - Option B: Manual with Maven (recommended for production)
    - Create a Maven webapp and move files accordingly. Add dependency for mysql-connector-java and jakarta.servlet-api.

5) Notes
 - The LoginServlet uses hardcoded demo credentials: admin / 1234
 - For production, never store DB credentials in source files. Use environment variables or a secure vault.

6) Questions?
 - If you want, I can:
    - Provide a ready .war file (if you give DB credentials now), or
    - Help with step-by-step deployment on Nimbus/Tomcat.
