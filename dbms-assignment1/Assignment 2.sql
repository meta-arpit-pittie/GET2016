/*Assignment 2*/
CREATE DATABASE LIS;

USE LIS;

/*Creating tables for the library information system */
CREATE TABLE members(
    member_id VARCHAR(20) PRIMARY KEY,
    member_name VARCHAR(40),
    address_line1 VARCHAR(50),
    address_line2 VARCHAR(50),
    category VARCHAR(30)
);

CREATE TABLE subjects(
    subject_id VARCHAR(20) PRIMARY KEY,
    subject_name VARCHAR(30)
);

CREATE TABLE publishers(
    publisher_id VARCHAR(20) PRIMARY KEY,
    publisher_name VARCHAR(40)
);

CREATE TABLE authors(
    author_id VARCHAR(20) PRIMARY KEY,
    author_name VARCHAR(40)
);

CREATE TABLE titles(
    title_id INT PRIMARY KEY,
    title_name VARCHAR(50),
    subject_id VARCHAR(20),
    publisher_id VARCHAR(20),
    CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id)
        REFERENCES publishers (publisher_id),
    CONSTRAINT fk_subject_id FOREIGN KEY (subject_id)
        REFERENCES subjects (subject_id)
);

CREATE TABLE books(
    accession_number INT PRIMARY KEY,
    title_id INT,
    purchase_dt DATE,
    price DECIMAL(7,2),
    status VARCHAR(20),
    CONSTRAINT fk_title_id_books FOREIGN KEY (title_id)
        REFERENCES titles (title_id)
);

CREATE TABLE title_author(
    title_id INT,
    author_id VARCHAR(20),
    PRIMARY KEY (title_id,author_id),
    CONSTRAINT fk_title_id_title_author FOREIGN KEY (title_id)
        REFERENCES titles (title_id),
    CONSTRAINT fk_author_id_title_author FOREIGN KEY (author_id)
        REFERENCES authors (author_id)
);

CREATE TABLE book_issue(
    issue_dt DATE,
    accession_number INT,
    member_id VARCHAR(20),
    due_dt DATE,
    PRIMARY KEY (issue_dt,accession_number,member_id),
    CONSTRAINT fk_accession_number_book_issue FOREIGN KEY (accession_number)
        REFERENCES books (accession_number),
    CONSTRAINT fk_member_id_book_issue FOREIGN KEY (member_id)
        REFERENCES members (member_id)
);

CREATE TABLE book_return(
    return_dt DATE,
    accession_number INT,
    member_id VARCHAR(20),
    issue_dt DATE,
    PRIMARY KEY (return_dt,accession_number,member_id),
    CONSTRAINT fk_accession_number_book_return FOREIGN KEY (accession_number)
        REFERENCES books (accession_number),
    CONSTRAINT fk_member_id_book_return FOREIGN KEY (member_id)
        REFERENCES members (member_id),
    CONSTRAINT fk_issue_dt_book_return FOREIGN KEY (issue_dt)
        REFERENCES book_issue (issue_dt)
);
    
/* Displaying all the table names present in the LIS */
SHOW TABLES;

/* Setting default values */
ALTER TABLE book_issue MODIFY COLUMN 
    issue_dt DATE DEFAULT CURDATE();
ALTER TABLE book_issue MODIFY COLUMN 
    due_dt DATE DEFAULT DATE_ADD(issue_dt, INTERVAL 15 DAY);

/* Removing the members table from the database */
ALTER TABLE book_issue DROP 
    FOREIGN KEY fk_member_id_book_issue;
ALTER TABLE book_return DROP 
    FOREIGN KEY fk_member_id_book_return;
DROP TABLE members;

/* Recreating the members table */
CREATE TABLE members(
    member_id VARCHAR(20) PRIMARY KEY,
    member_name VARCHAR(40),
    address_line1 VARCHAR(50),
    address_line2 VARCHAR(50),
    category VARCHAR(30)
);

/* Restting the Foreign Key Constraints */
ALTER TABLE book_issue ADD 
    CONSTRAINT fk_member_id_book_issue FOREIGN KEY (member_id) 
        REFERENCES members (member_id);
        
ALTER TABLE book_return ADD 
    CONSTRAINT fk_member_id_book_return FOREIGN KEY (member_id) 
        REFERENCES members (member_id);