-- ==========================================
-- Exercise 1: Control Structures
-- ==========================================

-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_older_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;
BEGIN
    FOR rec IN c_older_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
        
        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || rec.LoanID || 
                             ' (Customer ID: ' || rec.CustomerID || 
                             '). New Interest Rate: ' || (rec.InterestRate - 1) || '%');
    END LOOP;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in Scenario 1: ' || SQLERRM);
END;
/

-- Scenario 2: Promote a customer to VIP status based on their balance (> $10,000).
DECLARE
    CURSOR c_high_balance IS
        SELECT CustomerID, Balance, IsVIP
        FROM Customers
        WHERE Balance > 10000;
BEGIN
    FOR rec IN c_high_balance LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.CustomerID || 
                             ' promoted to VIP. Current Balance: $' || rec.Balance);
    END LOOP;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in Scenario 2: ' || SQLERRM);
END;
/

-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
DECLARE
    CURSOR c_due_loans IS
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Reminders for loans due in the next 30 days ---');
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || 
                             ', your Loan ID ' || rec.LoanID || 
                             ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in Scenario 3: ' || SQLERRM);
END;
/
