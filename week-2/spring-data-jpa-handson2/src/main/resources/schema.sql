CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS stock (
    st_id INT AUTO_INCREMENT PRIMARY KEY,
    st_code VARCHAR(10),
    st_date DATE,
    st_open NUMERIC(10,2),
    st_close NUMERIC(10,2),
    st_volume NUMERIC
);

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
