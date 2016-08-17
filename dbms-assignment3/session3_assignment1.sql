/* Assignment 1 */

/* Selecting the databse */
USE LIS;

/* To display information on books issued for more than 2 months.
 * It should include member name, member id, title name, accession number
 * issue date, due date and issued for how many months and be sorted on 
 * member name and then on title name. */
SELECT m.member_name AS 'Member Name', bi.member_id AS 'Member ID',
    t.title_name AS 'Title', bi.accession_number AS 'Accession Number',
    bi.issue_dt AS 'Issue Date', bi.due_dt AS 'Due Date', br.return_dt AS 'Return Date',
    TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) AS 'Number of Months' 
    FROM book_issue bi
    INNER JOIN members m ON bi.member_id = m.member_id
    INNER JOIN books b ON bi.accession_number = b.accession_number
    INNER JOIN titles t ON b.title_id = t.title_id
    LEFT JOIN book_return br ON br.accession_number = bi.accession_number 
        AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt
    WHERE TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) > 2 
    ORDER BY m.member_name, t.title_name;
    
/* To display those rows from members table having maximum length for member name */
SELECT member_name, LENGTH(member_name) AS 'Length' FROM members 
    WHERE LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM members);
    
/* To display count of number of books issued so far */
SELECT COUNT(accession_number) FROM book_issue;