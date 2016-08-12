/* Assignment 3 */

/* Selecting the database */
USE LIS;

/* To display total number of students, total number of faculty and total number of others
 * in library information system in a single row */
SELECT GROUP_CONCAT(m.category) AS 'Category', GROUP_CONCAT(m.count_value) AS 'Count'
    FROM (SELECT category, COUNT(member_id) AS count_value FROM members GROUP BY category) AS m;

/* To display the information of those titles that have been issued more than 2 times */
SELECT t.title_id AS 'Title Id', t.title_name AS 'Title Name',
    t.subject_id AS 'Subject Id', t.publisher_id AS 'Publisher Id',
    b.accession_number AS 'Book Id' FROM titles t 
    INNER JOIN books b ON t.title_id = b.title_id
    INNER JOIN book_issue bi ON b.accession_number = bi.accession_number
    GROUP BY bi.accession_number HAVING COUNT(bi.accession_number) > 2;

/* To display information on books  issued to members of category other than 'F' */
SELECT b.accession_number AS 'Book Id', b.title_id AS 'Title Id',
    t.title_name AS 'Title Name', m.member_name AS 'Member Name',
    m.category AS 'Category' FROM books b
    INNER JOIN titles t ON b.title_id = t.title_id
    INNER JOIN book_issue bi ON b.accession_number = bi.accession_number
    INNER JOIN members m ON bi.member_id = m.member_id
    WHERE m.category != 'F';

/* To display information on those authors for which atleast one book has been purchased*/
SELECT a.author_id AS 'Author Id', a.author_name AS 'Author Name'
    FROM authors a
    INNER JOIN title_author ta ON a.author_id = ta.author_id
    INNER JOIN books b ON ta.title_id = b.title_id
    WHERE b.status LIKE 'p%'
    GROUP BY a.author_id HAVING COUNT(b.accession_number) > 0;