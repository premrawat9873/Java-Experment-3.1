# 🌐 Web Applications Using Servlets and JSP  
### User Input Handling and Database Integration

This project demonstrates the use of **Java Servlets**, **JSP**, and **JDBC** to handle user input, perform database operations, and generate dynamic web pages.  
It consists of three parts:
1. **User Login Using Servlet and HTML Form**  
2. **Display Employee Records Using JDBC**  
3. **Student Attendance Portal Using JSP and Servlet**

---

## 📁 Project Structure



WebApp/
│
├── WebContent/
│ ├── index.html
│ ├── login.html
│ ├── employee.html
│ ├── attendance.jsp
│ ├── success.jsp
│ └── WEB-INF/
│ └── web.xml
│
├── src/
│ └── com/example/servlets/
│ ├── LoginServlet.java
│ ├── EmployeeServlet.java
│ └── AttendanceServlet.java
│
└── sql/
├── company.sql
└── school.sql


---

## 🧩 Features

### Part A — User Login
- HTML form collects username and password.
- Servlet validates credentials and displays a personalized welcome message.
- Invalid login shows an error.

### Part B — Employee Records
- Connects to MySQL using JDBC.
- Displays all employee records in a table.
- Allows search by Employee ID.

### Part C — Student Attendance Portal
- JSP form collects attendance details.
- Servlet inserts the data into the database.
- Displays success message on completion.

---

## 🛠️ Prerequisites

- Java JDK 8 or later  
- Apache Tomcat 9+  
- MySQL Server  
- MySQL JDBC Driver (`mysql-connector-java.jar`)  
- (Optional) Nimbus or any Java EE-compatible cloud environment

---

## ⚙️ Database Setup

1. Open MySQL terminal or phpMyAdmin.
2. Run the SQL scripts located in the `sql/` folder:

   ```sql
   SOURCE /path/to/sql/company.sql;
   SOURCE /path/to/sql/school.sql;


These create:

company database → Employee(EmpID, Name, Salary)

school database → Attendance(StudentID, Date, Status)

Verify with:

SHOW DATABASES;
USE company;
SELECT * FROM Employee;

🔧 Configure Database Connection

In both EmployeeServlet.java and AttendanceServlet.java, update the credentials:

final String DB_USER = "your_mysql_username";
final String DB_PASS = "your_mysql_password";


Make sure your database URL matches:

final String DB_URL = "jdbc:mysql://localhost:3306/company";


and for attendance:

final String DB_URL = "jdbc:mysql://localhost:3306/school";

🏗️ Build and Deployment Steps
Option 1: Running on Nimbus

Upload the project folder (WebApp/) to Nimbus.

Ensure Tomcat service is running.

Deploy the app via Nimbus dashboard.

Visit your deployment URL:

http://<your-nimbus-url>/WebApp/

Option 2: Running Locally on Tomcat

Copy the entire WebApp/ folder into:

<TOMCAT_HOME>/webapps/


Compile Servlets (if not using an IDE):

javac -classpath "<TOMCAT_HOME>/lib/servlet-api.jar" -d WebApp/WEB-INF/classes src/com/example/servlets/*.java


Start Tomcat:

<TOMCAT_HOME>/bin/startup.sh   # (Linux/macOS)
<TOMCAT_HOME>\bin\startup.bat  # (Windows)


Open in your browser:

http://localhost:8080/WebApp/

🌍 Application URLs
Feature	URL	Description
🔑 Login	/WebApp/login.html	User login with static credentials (admin/1234)
👨‍💼 Employee	/WebApp/employee.html	View all employees or search by ID
🧍 Attendance	/WebApp/attendance.jsp	Mark and store student attendance
🧠 Concepts Demonstrated

HTML form handling with Servlets

Request/Response processing

JDBC integration for data access

JSP as a front-end for user input

MVC (Model–View–Controller) pattern in web apps
