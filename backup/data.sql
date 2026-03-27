-- Admin
INSERT INTO admin(email, password) VALUES("admin", "admin");

-- Manager
INSERT INTO manager(name, username, password, phone_number)
VALUES("Apollo", "apollo", "apollo", "1234567890");

-- Client
INSERT INTO client(name, email, phone_number, address, latitude, longitude)
VALUES("Alex", "alex@mail.com", "1234567890", "214 College St", 43.65888649791208, -79.39664509816275);
INSERT INTO client(name, email, phone_number, address, latitude, longitude)
VALUES("Swan", "swan@mail.com", "1234567890", "147 Danforth Ave", 43.676492610923944, -79.35601028744495);
INSERT INTO client(name, email, phone_number, address, latitude, longitude)
VALUES("Beck", "beck@mail.com", "1234567890", "250 Fort York Blvd", 43.639640653215054, -79.40273459357108);

-- Employee
INSERT INTO employee(manager_id, name, username, password, phone_number)
VALUES(1, "John", "john", "john", "1234567890");
INSERT INTO employee(manager_id, name, username, password, phone_number)
VALUES(1, "Ena", "ena", "ena", "1234567890");

-- Job
INSERT INTO job(client_id, name, description, start_time, end_time, address, latitude, longitude)
VALUES(1, "Fix printer", "Fix 1 Epson printer and connect it to the network", "2025/12/19 13:00:00", "2025/12/19 15:00:00", "214 College St", 43.65888649791208, -79.39664509816275);
INSERT INTO job(client_id, name, description, start_time, end_time, address, latitude, longitude)
VALUES(2, "Deliver PC", "Deliver PC and install it at the house", "2025/12/19 9:00:00", "2025/12/19 10:00:00", "147 Danforth Ave", 43.676492610923944, -79.35601028744495);
INSERT INTO job(client_id, name, description, start_time, end_time, address, latitude, longitude)
VALUES(3, "Setup Network", "Wire the PCs to the router and set up the home network", "2025/12/20 9:00:00", "2025/12/20 12:00:00", "250 Fort York Blvd", 43.639640653215054, -79.40273459357108);
INSERT INTO job(client_id, name, description, start_time, end_time, address, latitude, longitude)
VALUES(1, "Get 2 laptops", "Retrieve 1 Asus laptop and 1 Acer laptop", "2025/12/21 10:00:00", "2025/12/21 11:00:00", "10 Dufferin St", 43.63275545238537, -79.42478686759095);

-- Employee Job
INSERT INTO employee_job(employee_id, job_id, start_time, end_time)
VALUES(2, 1, "2025/12/19 12:30:00", "2025/12/19 13:30:00");
INSERT INTO employee_job(employee_id, job_id, start_time, end_time)
VALUES(1, 2, "2025/12/19 8:00:00", "2025/12/19 8:15:00");
INSERT INTO employee_job(employee_id, job_id, start_time, end_time)
VALUES(1, 3, "2025/12/20 9:00:00", "2025/12/20 11:00:00");
INSERT INTO employee_job(employee_id, job_id, start_time, end_time)
VALUES(2, 3, "2025/12/20 9:00:00", "2025/12/20 11:00:00");
INSERT INTO employee_job(employee_id, job_id, start_time, end_time)
VALUES(1, 4, "2025/12/21 10:30:00", "2025/12/21 10:45:00");