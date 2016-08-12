/* Assignment 3 */

/* Selecting database */
USE LIS;

/* Inserting values to the table */
INSERT INTO members VALUES ( 'M16-001', 'XYZ', 'E-87', 'Vaishali Nagar', 'F' );
INSERT INTO members VALUES ( 'M16-002', 'Adam', 'Street no. 1', 'Jodhpur', 'F' );
INSERT INTO members VALUES ( 'M16-003', 'Luke', 'Flat F-2', 'Nirman Nagar', 'M' );
INSERT INTO members VALUES ( 'M16-004', 'Ardena', 'A/12, Shastri Nagar', 'Tonk Road', 'F' );
INSERT INTO members VALUES ( 'M16-005', 'abc', 'Row House No. 3', 'Sitapura', 'M' );

INSERT INTO subjects VALUES ( 'S-001', 'Fiction' );
INSERT INTO subjects VALUES ( 'S-002', 'Action' );
INSERT INTO subjects VALUES ( 'S-003', 'Romance' );
INSERT INTO subjects VALUES ( 'S-004', 'Fantasy' );
INSERT INTO subjects VALUES ( 'S-005', 'Study' );

INSERT INTO publishers VALUES ( '1', 'TMH' );
INSERT INTO publishers VALUES ( '2', 'Oracle Publications' );
INSERT INTO publishers VALUES ( '3', 'Salesforce' );
INSERT INTO publishers VALUES ( '4', 'Pearson' );
INSERT INTO publishers VALUES ( '5', 'Genius Publications' );

INSERT INTO authors VALUES ( 'A13-001', 'R.K.Sharma' );
INSERT INTO authors VALUES ( 'A13-002', 'Bipul Jain' );
INSERT INTO authors VALUES ( 'A14-001', 'Martin Luthor' );
INSERT INTO authors VALUES ( 'A14-002', 'Adam' );
INSERT INTO authors VALUES ( 'A14-003', 'Adil Mohammad' );

INSERT INTO titles VALUES ( 90001, 'The book of Life', 'S-001', '4' );
INSERT INTO titles VALUES ( 90002, 'Make It Happen', 'S-003', '4' );
INSERT INTO titles VALUES ( 90003, 'The Case of Missing City', 'S-002', '1' );
INSERT INTO titles VALUES ( 90004, 'All About Cloud', 'S-005', '3' );

INSERT INTO books VALUES ( 30001, 90001, '2015/01/01', 230.15, 'Rented' );
INSERT INTO books VALUES ( 30002, 90002, '2015/03/22', 1230.15, 'Purchased' );
INSERT INTO books VALUES ( 30003, 90003, '2016/04/15', 49.89, 'Rented' );
INSERT INTO books VALUES ( 30004, 90004, '2016/08/01', 5001.01, 'Rented' );

INSERT INTO title_author VALUES ( 90001, 'A13-002' );
INSERT INTO title_author VALUES ( 90002, 'A13-001' );
INSERT INTO title_author VALUES ( 90003, 'A13-002' );
INSERT INTO title_author VALUES ( 90004, 'A14-003' );

INSERT INTO book_issue VALUES ( '2016/08/10', 30001, 'M16-001', '2016/08/25' );
INSERT INTO book_issue VALUES ( '2016/08/10', 30002, 'M16-003', '2016/08/25' );
INSERT INTO book_issue VALUES ( '2016/08/10', 30003, 'M16-003', '2016/08/25' );

INSERT INTO book_return VALUES ( '2016/08/20', 30003, 'M16-003', '2016/08/10' );
INSERT INTO book_return VALUES ( '2016/08/25', 30001, 'M16-001', '2016/08/10' );

/* Change values of address_line2 in members table to 'Jaipur' */
UPDATE members SET address_line2 = 'Jaipur';

/* Change values of address_line1 in members table to 'EPIP, Sitapura' */
UPDATE members SET address_line1 = 'EPIP, Sitapura' WHERE category = 'F';

/* Deleting all rows from publisher table */
ALTER TABLE titles DROP 
    FOREIGN KEY fk_publisher_id;
DELETE FROM publishers;

/* Inserting the data back to the publisher table using substitution variables */
SET @id = '1';
SET @name = 'TMH';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '2';
SET @name = 'Oracle Publications';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '3';
SET @name = 'Salesforce';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '4';
SET @name = 'pEARSON';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '5';
SET @name = 'Genius Publications';
INSERT INTO publishers VALUES ( @id, @name );

ALTER TABLE titles ADD 
    CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id) 
        REFERENCES publishers (publisher_id);

/* Deleting rows of title table with publisher id = 1 */
DELETE FROM titles WHERE publisher_id = '1';