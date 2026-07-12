-- Payroll Tables
CREATE TABLE IF NOT EXISTS department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(100) NOT NULL,
    em_salary NUMERIC(10,2) NOT NULL,
    em_permanent BOOLEAN NOT NULL,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE IF NOT EXISTS skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id) ON DELETE CASCADE,
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id) ON DELETE CASCADE
);

-- Quiz Tables
CREATE TABLE IF NOT EXISTS user_table (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_us_id INT,
    at_date TIMESTAMP,
    FOREIGN KEY (at_us_id) REFERENCES user_table(us_id)
);

CREATE TABLE IF NOT EXISTS question (
    qt_id INT AUTO_INCREMENT PRIMARY KEY,
    qt_text VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS quiz_option (
    op_id INT AUTO_INCREMENT PRIMARY KEY,
    op_qt_id INT,
    op_text VARCHAR(100) NOT NULL,
    op_is_correct BOOLEAN NOT NULL,
    op_score DOUBLE NOT NULL,
    FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT,
    aq_qt_id INT,
    PRIMARY KEY (aq_id),
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_aq_id INT,
    ao_op_id INT,
    ao_is_selected BOOLEAN NOT NULL,
    PRIMARY KEY (ao_id),
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    FOREIGN KEY (ao_op_id) REFERENCES quiz_option(op_id)
);
