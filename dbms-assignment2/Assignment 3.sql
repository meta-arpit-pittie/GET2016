/* Assignment 3 */

/* Creating the database */
CREATE DATABASE eCommerce;

/* Selecting the database */
USE eCommerce;

/* Creting the category table */
CREATE TABLE Categories (
    category_id VARCHAR(30),
    category_name VARCHAR(50),
    parent_category VARCHAR(20),
    PRIMARY KEY (category_id),
    CONSTRAINT fk_parent_category FOREIGN KEY (parent_category)
        REFERENCES Categories (category_id)
);

/* Inserting the values into the table */
INSERT INTO categories VALUES ('CAT-1001', 'Mobiles & Tablets', NULL);

INSERT INTO categories VALUES ('CAT-1001-01', 'Mobiles', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-01-001', 'Smart Phones', 'CAT-1001-01');
INSERT INTO categories VALUES ('CAT-1001-01-002', 'Feature Phones', 'CAT-1001-01');

INSERT INTO categories VALUES ('CAT-1001-02', 'Tablets', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-02-001', '2G', 'CAT-1001-02');
INSERT INTO categories VALUES ('CAT-1001-02-002', '3G', 'CAT-1001-02');

INSERT INTO categories VALUES ('CAT-1001-03', 'Accessories', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-04', 'Cases and Covers', 'CAT-1001');


INSERT INTO categories VALUES ('CAT-1002', 'Computers', NULL);
INSERT INTO categories VALUES ('CAT-1002-01', 'Desktop', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-02', 'Laptop', 'CAT-1002');

INSERT INTO categories VALUES ('CAT-1002-03', 'Laptop Accessories', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-03-001', 'Keyboard', 'CAT-1002-03');
INSERT INTO categories VALUES ('CAT-1002-03-002', 'Mouse', 'CAT-1002-03');
INSERT INTO categories VALUES ('CAT-1002-03-003', 'Headphones', 'CAT-1002-03');

INSERT INTO categories VALUES ('CAT-1002-04', 'Printers', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-04-001', 'Inkjet', 'CAT-1002-04');
INSERT INTO categories VALUES ('CAT-1002-04-002', 'Laser', 'CAT-1002-04');


INSERT INTO categories VALUES ('CAT-1003', 'Home Appliances', NULL);

INSERT INTO categories VALUES ('CAT-1003-01', 'TVs', 'CAT-1003');
INSERT INTO categories VALUES ('CAT-1003-01-001', 'LED', 'CAT-1003-01');
INSERT INTO categories VALUES ('CAT-1003-01-002', 'LCD', 'CAT-1003-01');
INSERT INTO categories VALUES ('CAT-1003-01-003', 'Plasma', 'CAT-1003-01');

INSERT INTO categories VALUES ('CAT-1003-02', 'Air Conditioners', 'CAT-1003');

INSERT INTO categories VALUES ('CAT-1003-03', 'Washing Machines', 'CAT-1003');

INSERT INTO categories VALUES ('CAT-1003-03-001', 'Full Automatic', 'CAT-1003-03');
INSERT INTO categories VALUES ('CAT-1003-03-001-01', 'Top Load', 'CAT-1003-03-001');
INSERT INTO categories VALUES ('CAT-1003-03-001-02', 'Front Load', 'CAT-1003-03-001');

INSERT INTO categories VALUES ('CAT-1003-03-002', 'Semi Automatic', 'CAT-1003-03');

/* To display all the categories along with their parent category */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    p.category_name AS 'Parent Category' FROM categories c 
    LEFT JOIN categories p ON c.parent_category = p.category_id;

/* To display all the categories along with their parent category,
 * sorted on the basis of parent category */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    p.category_name AS 'Parent Category' FROM categories c 
    LEFT JOIN categories p ON c.parent_category = p.category_id ORDER BY p.category_name;

/* To display all the categories along with their parent category.
 * If it is top category then display  'Top Category' for parent category */
 SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    IFNULL (p.category_name, 'Top Category') AS 'Parent Category'
    FROM categories c LEFT JOIN categories p ON c.parent_category = p.category_id;

/* To display only the top categories. */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    IFNULL (p.category_name, 'Top Category') AS 'Parent Category'
    FROM categories c LEFT JOIN categories p ON c.parent_category = p.category_id
    WHERE c.parent_category IS NULL;