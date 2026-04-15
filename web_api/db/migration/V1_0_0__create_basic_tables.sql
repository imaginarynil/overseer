CREATE TABLE IF NOT EXISTS admin (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    creation_date DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS manager (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    creation_date DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS employee (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- when assigning new employees to a manager, an employee can be without a manager
    manager_id INT,
	name VARCHAR(100) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
	latitude DECIMAL(8, 6),
	longitude DECIMAL(9, 6),
    creation_date DATETIME NOT NULL DEFAULT NOW()
);
ALTER TABLE employee
    ADD CONSTRAINT fk_employee_manager
    FOREIGN KEY (manager_id) REFERENCES manager(id) ON DELETE SET NULL;

/*
-- modify manager_id to nullable
ALTER TABLE employee MODIFY COLUMN manager_id INT NULL;

-- add on delete set null

-- find fk constraint name
SHOW CREATE TABLE employee;
-- drop fk constraint
ALTER TABLE employee DROP FOREIGN KEY employee_ibfk_1;
-- add on delete cascade
ALTER TABLE employee
    ADD CONSTRAINT fk_employee_manager
    FOREIGN KEY (manager_id)
    REFERENCES manager(id)
    ON DELETE SET NULL;
*/

CREATE TABLE IF NOT EXISTS client (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL,
	latitude DECIMAL(8, 6),
	longitude DECIMAL(9, 6),
    creation_date DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS job (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
	name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    address VARCHAR(100) NOT NULL,
	latitude DECIMAL(8, 6) NOT NULL,
	longitude DECIMAL(9, 6) NOT NULL,
    creation_date DATETIME NOT NULL DEFAULT NOW(),
    update_date DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW()
);
ALTER TABLE job
    ADD CONSTRAINT fk_job_client
    FOREIGN KEY (client_id) REFERENCES client(id);

CREATE TABLE IF NOT EXISTS employee_job (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employee_id INT NOT NULL,
    job_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    creation_date DATETIME NOT NULL DEFAULT NOW()
);
ALTER TABLE employee_job
    ADD CONSTRAINT fk_employee_job_employee
    FOREIGN KEY (employee_id) REFERENCES employee(id);
ALTER TABLE employee_job
    ADD CONSTRAINT fk_employee_job_job
    FOREIGN KEY (job_id) REFERENCES job(id);