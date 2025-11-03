-- company database and Employee table
CREATE DATABASE IF NOT EXISTS company;
USE company;

CREATE TABLE IF NOT EXISTS Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DECIMAL(10,2)
);

INSERT INTO Employee (EmpID, Name, Salary) VALUES
(101, 'Alice', 50000.00),
(102, 'Bob', 60000.00),
(103, 'Charlie', 55000.00);
