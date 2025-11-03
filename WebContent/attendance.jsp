<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Attendance Portal</title>
</head>
<body>
    <h2>Mark Attendance</h2>
    <form action="AttendanceServlet" method="post">
        <label>Student ID: <input type="text" name="studentId" required></label><br><br>
        <label>Date: <input type="date" name="date" required></label><br><br>
        <label>Status:
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select></label><br><br>
        <input type="submit" value="Submit">
    </form>
    <p><a href="index.html">Home</a></p>
</body>
</html>
