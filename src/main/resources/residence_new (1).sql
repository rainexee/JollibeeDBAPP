DROP DATABASE IF EXISTS Residence_SQL_test;
CREATE DATABASE IF NOT EXISTS Residence_SQL_test;
USE Residence_SQL_test;

-- Drop tables if they exist to prevent foreign key or duplicate issues
DROP TABLE IF EXISTS transfers;

DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS house_owner;

DROP TABLE IF EXISTS tenant_dues;
DROP TABLE IF EXISTS house;
DROP TABLE IF EXISTS land;


-- Land Table
CREATE TABLE IF NOT EXISTS land (
    land_id INT NOT NULL,
    land_size FLOAT NOT NULL,
    land_price FLOAT NOT NULL DEFAULT 0, -- can be "undistinguished" for unknown prices
    landprogress VARCHAR(50) NOT NULL, -- e.g., In-development, undeveloped, developed
    land_sold TINYINT,
    PRIMARY KEY(land_id)
);

CREATE TABLE IF NOT EXISTS land_owner (
    owner_id INT NOT NULL,
    owner_lastName VARCHAR(100) NOT NULL,
    owner_firstName VARCHAR(100) NOT NULL,
    owner_email VARCHAR(50) NOT NULL UNIQUE,
    owner_phoneNumber VARCHAR(45) NOT NULL UNIQUE,
    land_landNumber INT NOT NULL,
    owner_startDate DATE NOT NULL,
    owner_endDate DATE,
    PRIMARY KEY(owner_id),
    FOREIGN KEY(land_landNumber) REFERENCES land(land_id) ON DELETE CASCADE
);



-- Employee Table
CREATE TABLE IF NOT EXISTS employee (
    employee_id INT NOT NULL,
    employee_lastName VARCHAR(100) NOT NULL,
    employee_firstName VARCHAR(100) NOT NULL,
    employee_email VARCHAR(50) NOT NULL UNIQUE,
    employee_phoneNumber VARCHAR(40) NOT NULL UNIQUE,
    PRIMARY KEY(employee_id)
);

-- Insert data into Employee Table
INSERT INTO employee (employee_id, employee_lastName, employee_firstName, employee_email, employee_phoneNumber)
VALUES 
(1001, 'Seinfeld', 'Jerry', 'jerryseinfeld@gmail.com', '+63 418 254 1320'),
(1002, 'Welles', 'Orson', 'orsonwelles@gmail.com', '+63 567 829 6641'),
(1003, 'Jackson', 'Samuel', 'samueljackson@gmail.com', '+63 785 146 4423'),
(1004, 'Snyder', 'Zach', 'zachsnyder@gmail.com', '+63 849 667 2447'),
(1005, 'Richie', 'Lionel', 'lionelrichie@gmail.com', '+63 298 100 6994');

-- House Table
CREATE TABLE IF NOT EXISTS house (
    houseNumber INT NOT NULL,
    houseSize FLOAT NOT NULL,
    description VARCHAR(150),
    dateStarted DATE,
    dateOfCompletion DATE,
    house_price FLOAT, -- Price of the house
    house_address VARCHAR(100) NOT NULL, -- Address of the house
    land_landId INT NOT NULL,
    employee_employeeId INT, -- employee in charge of the house or person in charge
    PRIMARY KEY(houseNumber),
    FOREIGN KEY(land_landId) REFERENCES land(land_id) ON DELETE CASCADE,   -- ON DELETE CASCADE?
    FOREIGN KEY(employee_employeeId) REFERENCES employee(employee_id) ON DELETE SET NULL -- ON DELETE CASCADE?
);

-- House Owner Table
CREATE TABLE IF NOT EXISTS house_owner (
    owner_id INT NOT NULL,
    owner_lastName VARCHAR(100) NOT NULL,
    owner_firstName VARCHAR(100) NOT NULL,
    owner_email VARCHAR(50) NOT NULL UNIQUE,
    owner_phoneNumber VARCHAR(45) NOT NULL UNIQUE,
    house_houseNumber INT NOT NULL,
    owner_startDate DATE NOT NULL,
    owner_endDate DATE,
    PRIMARY KEY(owner_id),
    FOREIGN KEY(house_houseNumber) REFERENCES house(houseNumber) ON DELETE CASCADE
);


-- Tenant Table
CREATE TABLE IF NOT EXISTS tenant (
    tenant_id INT NOT NULL,
    tenant_lastName VARCHAR(100) NOT NULL,
    tenant_firstName VARCHAR(100) NOT NULL,
    tenant_contactNumber VARCHAR(40) NOT NULL UNIQUE,
    tenant_email VARCHAR(50) NOT NULL UNIQUE,
    tenant_houseNumber INT NOT NULL,
    occupancyDate DATE NOT NULL,
    contractExpiration DATE NOT NULL,
    PRIMARY KEY(tenant_id),
	FOREIGN KEY(tenant_houseNumber) REFERENCES house(houseNumber) ON DELETE CASCADE -- ON DELETE CASCADE
);











-- Tenant DUES Table
CREATE TABLE IF NOT EXISTS tenant_dues (

	tenant_id INT NOT NULL,
	tenant_dues FLOAT DEFAULT 0,
    tenant_datePaid DATE,
    tenant_dueDate DATE,
    
    PRIMARY KEY(tenant_id),
	FOREIGN KEY(tenant_id) REFERENCES tenant(tenant_id) ON DELETE CASCADE -- ON DELETE CASCADE

);







-- Transfer Table
CREATE TABLE IF NOT EXISTS transfers (
    transfer_id INT NOT NULL,
    old_ownerID INT NULL,
    old_houseOwnerLastName VARCHAR(100) NOT NULL,
    old_houseOwnerFirstName VARCHAR(100) NOT NULL,
    new_houseOwnerLastName VARCHAR(100) NOT NULL,
    new_houseOwnerFirstName VARCHAR(100) NOT NULL,
    employee_id INT,
    sales_id INT NOT NULL,
    houseNumber INT NULL,
    PRIMARY KEY(transfer_id),
    FOREIGN KEY(houseNumber) REFERENCES house(houseNumber) ON DELETE SET NULL,
    FOREIGN KEY(old_ownerID) REFERENCES house_owner(owner_id) ON DELETE SET NULL
   
);



-- Sales Table
CREATE TABLE IF NOT EXISTS sales (
    sales_id INT NOT NULL,
    employee_id INT NOT NULL,
    owner_id INT,
    sale_category VARCHAR(45) NOT NULL,
    houseNumber INT,
    land_id INT,
    transfer_id INT,
    amount_paid FLOAT,
	sale_date DATE NOT NULL,
    PRIMARY KEY(sales_id),
    FOREIGN KEY(houseNumber) REFERENCES house(houseNumber) ON DELETE SET NULL,  -- ON DELETE CASCADE
    FOREIGN KEY(land_id) REFERENCES land(land_id) ON DELETE SET NULL, -- ON DELETE CASCADE?
    FOREIGN KEY(transfer_id) REFERENCES transfers(transfer_id), 
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id) -- ON DELETE CASCADE?
   
);

-- Insert data into Land Table
INSERT INTO land (land_id, land_size, land_price, landprogress, land_sold)
VALUES 
(1001, 2000000, '900000', 'IN DEVELOPMENT', TRUE),
(1002, 2250000, 0, 'DEVELOPED', TRUE),
(1003, 3000000, '2500000', 'UNDEVELOPED', TRUE),
(1004, 2000000, '1000000', 'DEVELOPED', TRUE),
(1005, 2000000, 0, 'DEVELOPED', TRUE);

INSERT INTO land_owner(owner_id, owner_lastName, owner_firstName, owner_email, owner_phoneNumber, land_landNumber, owner_startDate, owner_endDate)
VALUES
(1001, 'Bobson', 'Bob', 'bobson_bob@gmail.com', '09876543211', 1001,  '2022-06-09', NULL),
(1002, 'Joeson', 'Joe', 'joeson_joe@gmail.com', '09876543212', 1002, '2023-08-09', NULL),
(1003, 'Louison', 'Louie', 'louison_louie@gmail.com', '09876543213', 1003, '2024-07-22', NULL),
(1004, 'Madaughter', 'Mary', 'madaughter_mary@gmail.com', '09876543214', 1004, '2022-02-06', NULL), 
(1005, 'Oldman', 'Gary', 'oldman_gary@gmail.com', '09876543215', 1005, '2022-02-06', NULL);

INSERT INTO house (houseNumber, houseSize, description, dateStarted, dateOfCompletion, house_price, house_address, land_landId, employee_employeeId)
VALUES
(01, 2500000, 'Red Roof', '2021-04-05', '2023-08-08', 500000, '280 Grove Street', 1002, 1005),
(02, 3000000, 'Has Closing Door for Garage', '2020-02-07', '2023-03-05', 1500000, '140 Sandra Blvd', 1004, 1002),
(03, 3000000, 'Glass Windows', '2018-03-12', '2021-02-04', 1750000, '62 Palm Street', 1005, 1004),
(04, 3500000, 'Gardening Area', '2021-02-11', '2024-11-06', 2500000, '24 Pharm Road', 1003, 1001),
(05, 2000000, 'Has many lights', '2020-04-11', '2022-08-01', 250000, '190 Gary Blvd.', 1001, 1003);



INSERT INTO house_owner(owner_id, owner_lastName, owner_firstName, owner_email, owner_phoneNumber, house_houseNumber, owner_startDate, owner_endDate)
VALUES
(1001, 'Willman', 'Peter', 'peterwillman@gmail.com', '+63 784 526 1432', 03, '2022-06-09', NULL),
(1002, 'Verrily', 'Stan', 'stanverrily@gmail.com', '+63 239 546 9015', 01, '2023-10-19', NULL),
(1003, 'Hermin', 'Ford', 'fordhermin@gmail.com', '+63 889 266 3819', 04, '2024-11-09', NULL),
(1004, 'Harrison', 'George', 'georgeharrison@gmail.com', '+63 390 223 4267', 02, '2023-09-09', NULL),
(1005, 'Randford', 'Floyd', 'floydrandford@gmail.com', '+63 540 626 3432', 05, '2023-02-17', NULL);


INSERT INTO tenant (tenant_id, tenant_lastName, tenant_firstName, tenant_contactNumber, tenant_email, tenant_houseNumber, occupancyDate, contractExpiration)
VALUES
(1001, 'Henceworth', 'Jack', '63 425 123 9001', 'jackhenceworth@gmail.com', 02, '2023-08-05', '2025-02-08'),
(1002, 'Conway', 'Jimmy', '63 667 829 8209', 'jimmyconway@gmail.com', 01, '2023-08-09', '2025-04-12'),
(1003, 'Remmings', 'Tommy', '63 223 678 1023', 'tommyremmings@gmail.com', 04,  '2024-07-22', '2026-02-05'),
(1004, 'Zafferin', 'Mick', '63 782 337 2947', 'mickzafferin@gmail.com', 05, '2022-02-06', '2024-02-08'),
(1005, 'Jawery', 'Brad', '63 395 349 4586', 'bradjawery@gmail.com', 03,  '2024-02-06', '2026-07-15');






INSERT INTO transfers(transfer_id, old_ownerID, old_houseOwnerLastName, old_houseOwnerFirstName, new_houseOwnerLastName, new_houseOwnerFirstName,  employee_id, sales_id, houseNumber)
VALUES
(1001, 1004, 'Stronnman', 'Oliver', 'Willman', 'Peter', 1005, 100, 03),
(1002, 1002, 'Ford', 'Harrison', 'Verrily', 'Stan', 1003,1002, 01),
(1003, 1003, 'Culkin', 'McCauley',  'Hermin', 'Ford', 1002,1003, 04),
(1004, 1001, 'McDonald', 'Edward', 'Harrison', 'George', 1001, 1004, 02),
(1005, 1005, 'Hamill', 'Mark',  'Randford', 'Floyd', 1004, 1005, 05);

INSERT INTO sales( sales_id, employee_id, owner_id, sale_category, houseNumber, land_id, transfer_id, amount_paid, sale_date)
VALUES
(1001, 1003, 1004, 'transfer', 02, NULL, NULL, 500000, '2023-07-27'),
(1002, 1002, 1005, 'transfer', 01, NULL, NULL, 530000, '2022-03-14'),
(1003, 1004, 1003, 'land', NULL, 1001, NULL, 620000, '2022-03-18'),
(1004, 1005, 1002, 'land', NULL, 1003, NULL, 700000, '2021-09-28'),
(1005, 1001, 1001, 'transfer', 04, NULL, NULL, 900000, '2024-08-03');
INSERT INTO tenant_dues (tenant_id, tenant_dues, tenant_datePaid, tenant_dueDate )
VALUES
(1001, 50000, '2023-04-05', '2024-01-01'),
(1002, 50000, '2022-06-05', '2023-04-05'),
(1003, 50000, NULL, '2024-11-22'),
(1004, 50000, '2022-10-05', '2022-07-11'),
(1005, 50000, '2024-03-15', '2024-06-01');
