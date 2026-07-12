-- ==========================================
-- Payroll Seed Data
-- ==========================================
INSERT INTO department (dp_id, dp_name) VALUES (1, 'IT');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'HR');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Finance');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (1, 'John Doe', 65000.00, TRUE, TO_DATE('1990-05-15', 'YYYY-MM-DD'), 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (2, 'Jane Smith', 55000.00, FALSE, TO_DATE('1995-10-20', 'YYYY-MM-DD'), 2);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (3, 'Mike Ross', 75000.00, TRUE, TO_DATE('1988-08-30', 'YYYY-MM-DD'), 1);

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'SQL');

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 3);

-- ==========================================
-- Quiz Seed Data
-- ==========================================
INSERT INTO user_table (us_id, us_name) VALUES (1, 'admin');

INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, CURRENT_TIMESTAMP);

-- Question 1
INSERT INTO question (qt_id, qt_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (1, 1, '.xhtm', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (2, 1, '.ht', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (3, 1, '.html', TRUE, 1.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (4, 1, '.htmx', FALSE, 0.0);

-- Question 2
INSERT INTO question (qt_id, qt_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (5, 2, '5', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (6, 2, '3', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (7, 2, '4', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (8, 2, '6', TRUE, 1.0);

-- Question 3
INSERT INTO question (qt_id, qt_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (9, 3, 'false', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (10, 3, 'true', TRUE, 1.0);

-- Question 4
INSERT INTO question (qt_id, qt_text) VALUES (4, 'Choose the right option to store text value value in a variable');
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (11, 4, '''John''', TRUE, 0.5);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (12, 4, 'John', FALSE, 0.0);
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (13, 4, '"John"', FALSE, 0.5); -- correct option in SQL representation
INSERT INTO quiz_option (op_id, op_qt_id, op_text, op_is_correct, op_score) VALUES (14, 4, '/John/', FALSE, 0.0);

-- Attempt Question Links (at_id = 1)
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (4, 1, 4);

-- Attempt Option Links (ao_is_selected)
-- Q1: selected '.html' (op_id = 3)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (1, 1, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (1, 2, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (1, 3, TRUE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (1, 4, FALSE);

-- Q2: selected '3' (op_id = 6)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (2, 5, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (2, 6, TRUE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (2, 7, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (2, 8, FALSE);

-- Q3: selected 'true' (op_id = 10)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (3, 9, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (3, 10, TRUE);

-- Q4: selected ''John'' (op_id = 11)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (4, 11, TRUE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (4, 12, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (4, 13, FALSE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_is_selected) VALUES (4, 14, FALSE);
