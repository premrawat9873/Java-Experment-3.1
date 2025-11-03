-- school database and Attendance table
CREATE DATABASE IF NOT EXISTS school;
USE school;

CREATE TABLE IF NOT EXISTS Attendance (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID VARCHAR(50),
    Date DATE,
    Status VARCHAR(10)
);

-- sample row
INSERT INTO Attendance (StudentID, Date, Status) VALUES ('S001', '2025-01-01', 'Present');
