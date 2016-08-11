/* Assignment 1 */

/* Selecting the databse */
USE LIS;

/* To display all columns of member table */
SELECT member_id, member_name, address_line1, address_line2, category FROM members;

/* To display member name, member id and category of member table */
SELECT member_name, member_id, category FROM members;

/* To display member name, member id and category of member table 
 * where the category of member is Faculty i.e. F */
SELECT member_name, member_id, category FROM members WHERE category='F';

/* To display various categories of member */
SELECT DISTINCT category FROM members;

/* To display member name and category in descending order of member name */
SELECT member_name, category FROM members ORDER BY member_name DESC;

/* To display all titles, their subjects and their publishers */
SELECT t.title_name, s.subject_name, p.publisher_name FROM titles t 
    INNER JOIN subjects s ON t.subject_id = s.subject_id
    INNER JOIN publishers p ON t.publisher_id = p.publisher_id;

/* To display number of members present in each category */
SELECT category, COUNT(member_id) AS 'Number Of Members' FROM members GROUP BY category;

/* To display name of those members who belongs to the same category
 * as to which 'Keshav Sharma' belongs */
SELECT m.member_name FROM members m INNER JOIN members c 
    ON m.category = c.category WHERE c.member_name='Keshav Sharma';

/* To display information on all the books issued. The result should have issue date, 
 * accessin number, member id, member name and return date. If book is not returned,
 * keep the return date column blank. */
SELECT bi.issue_dt AS 'Issue Date', bi.accession_number AS 'Accession Number',
    bi.member_id AS 'Member ID', br.return_dt FROM book_issue bi LEFT JOIN
        book_return br ON bi.accession_number = br.accession_number;