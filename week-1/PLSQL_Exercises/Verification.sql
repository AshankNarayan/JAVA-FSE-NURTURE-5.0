-- ==========================================
-- Verification Script for PL/SQL Exercises
-- ==========================================

-- Enable DBMS Output
SET SERVEROUTPUT ON;

-- 1. Run Schema Setup first:
-- @SchemaSetup.sql

-- 2. Run Control Structures scripts:
-- @ControlStructures.sql

-- 3. Run Stored Procedures scripts:
-- @StoredProcedures.sql

-- 4. Verify Stored Procedure: ProcessMonthlyInterest
SELECT AccountID, AccountType, Balance FROM Accounts;
EXEC ProcessMonthlyInterest;
SELECT AccountID, AccountType, Balance FROM Accounts;

-- 5. Verify Stored Procedure: UpdateEmployeeBonus
SELECT EmployeeID, Name, Department, Salary, Bonus FROM Employees;
EXEC UpdateEmployeeBonus('IT', 10);
SELECT EmployeeID, Name, Department, Salary, Bonus FROM Employees;

-- 6. Verify Stored Procedure: TransferFunds
-- Successful transfer
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1001, 1002);
EXEC TransferFunds(1002, 1001, 2000);
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1001, 1002);

-- Failed transfer (insufficient balance)
-- EXEC TransferFunds(1002, 1001, 100000);
