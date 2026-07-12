-- ==========================================
-- Exercise 3: Stored Procedures
-- ==========================================

-- Scenario 1: Stored procedure to process monthly interest for all savings accounts (1% interest).
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastUpdate = SYSDATE
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings Accounts.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        RAISE;
END;
/

-- Scenario 2: Stored procedure to update employee salary by adding a bonus percentage parameter.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Verify valid percentage input
    IF p_bonus_percentage < 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Bonus percentage cannot be negative.');
    END IF;

    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100),
        Bonus = Bonus + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Updated salary of employees in department: ' || p_department || 
                         ' with a ' || p_bonus_percentage || '% bonus.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
        RAISE;
END;
/

-- Scenario 3: Stored procedure to transfer funds between accounts with balance checking.
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check for valid transfer amount
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be positive.');
    END IF;

    -- Fetch and lock the source account's balance to prevent concurrency issues
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    -- Validate sufficient funds
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance. Source Account ID ' || 
                                 p_from_account || ' balance is $' || v_balance || 
                                 '. Requested: $' || p_amount);
    ELSE
        -- Deduct from sender
        UPDATE Accounts
        SET Balance = Balance - p_amount,
            LastUpdate = SYSDATE
        WHERE AccountID = p_from_account;

        -- Add to receiver
        UPDATE Accounts
        SET Balance = Balance + p_amount,
            LastUpdate = SYSDATE
        WHERE AccountID = p_to_account;

        DBMS_OUTPUT.PUT_LINE('Transferred $' || p_amount || ' from Account ' || 
                             p_from_account || ' to Account ' || p_to_account || '.');
        COMMIT;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'One or both Account IDs are invalid.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error transferring funds: ' || SQLERRM);
        RAISE;
END;
/
