--table customers created--
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER,
    balance NUMBER(10, 2),
    is_vip CHAR(1) DEFAULT 'N'  -- 'Y' for VIP, 'N' for non-VIP
);
--table loans created--
CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER(5, 2),
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Customers
INSERT INTO customers VALUES (1, 'Alice', 65, 12000, 'N');
INSERT INTO customers VALUES (2, 'Bob', 45, 8000, 'N');
INSERT INTO customers VALUES (3, 'Charlie', 70, 20000, 'N');
INSERT INTO customers VALUES (4, 'David', 30, 9500, 'N');

-- Loans
INSERT INTO loans VALUES (101, 1, 7.5, SYSDATE + 15);
INSERT INTO loans VALUES (102, 2, 8.0, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 6.5, SYSDATE + 10);
INSERT INTO loans VALUES (104, 4, 7.0, SYSDATE + 5);

select * from Customers;
select * from loans;
--Exercise 1--
--scenario 1
BEGIN
    FOR rec IN (
        SELECT c.customer_id, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60
    ) LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = rec.loan_id;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to loan ID ' || rec.loan_id || ' for customer ID ' || rec.customer_id);
    END LOOP;
END;
--scenario 2
BEGIN
    FOR rec IN (
        SELECT customer_id FROM customers WHERE balance > 10000
    ) LOOP
        UPDATE customers
        SET is_vip = 'Y'
        WHERE customer_id = rec.customer_id;

        DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.customer_id || ' promoted to VIP.');
    END LOOP;
END;
--scenario 3
BEGIN
    FOR rec IN (
        SELECT c.name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.loan_id || ' for ' || rec.name || ' is due on ' || TO_CHAR(rec.due_date, 'DD-Mon-YYYY'));
    END LOOP;
END;
select * from loans
--table savings_accounts created
CREATE TABLE savings_accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER(10, 2)
);
INSERT INTO savings_accounts VALUES (201, 1, 10000);
INSERT INTO savings_accounts VALUES (202, 2, 8500);
INSERT INTO savings_accounts VALUES (203, 3, 12000);

--Exercise 3
--Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (SELECT account_id, balance FROM savings_accounts) LOOP
        UPDATE savings_accounts
        SET balance = balance + (balance * 0.01)
        WHERE account_id = acc.account_id;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
END;
call ProcessMonthlyInterest()
select * from savings_accounts


CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    ename VARCHAR2(50),
    dept_id NUMBER,
    salary NUMBER(10, 2)
);
INSERT INTO employees VALUES (301, 'Alice', 10, 50000);
INSERT INTO employees VALUES (302, 'Bob', 20, 45000);
INSERT INTO employees VALUES (303, 'Charlie', 10, 60000);

--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept_id IN NUMBER,
    p_bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_pct / 100)
    WHERE dept_id = p_dept_id;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to department ' || p_dept_id);
END;
call UpdateEmployeeBonus(10,15)
select * from employees
CREATE TABLE bank_accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER(10, 2)
);
INSERT INTO bank_accounts VALUES (401, 1, 15000);
INSERT INTO bank_accounts VALUES (402, 2, 5000);
COMMIT;

--Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Check balance of source account
    SELECT balance INTO v_balance
    FROM bank_accounts
    WHERE account_id = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    ELSE
        -- Deduct from source
        UPDATE bank_accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;

        -- Add to destination
        UPDATE bank_accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;

        DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from ' || p_from_account || ' to ' || p_to_account);
    END IF;
END;

call TransferFunds(401, 402, 2000);
select * from savings_accounts