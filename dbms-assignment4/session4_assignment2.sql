/* Assignment 2 */

/* Selecting the database */
USE LIS;

/* Create a View which can be used to display member name and
 * all issue details of the member using a simple SELECT command */
 CREATE VIEW member_issue_details AS
    SELECT m.member_name, bi.issue_dt, bi.accession_number,
        bi.member_id, bi.due_dt FROM book_issue bi
        INNER JOIN members m ON bi.member_id = m.member_id;
        
/* Using the above view to display issue details of a member */
SELECT member_name, issue_dt, due_dt, accession_number
    FROM member_issue_details WHERE member_id = 'M16-004';
    
/* Create a View which contains three columns, member name, member id 
 * and full description of category, i.e., Faculty, Students 
 * and Others instead of F,S and O */
 CREATE VIEW member_category_description AS
    SELECT member_name, member_id, 
        CASE category
            WHEN 'F' THEN 'Faculty'
            WHEN 'S' THEN 'Student'
            ELSE 'Others'
        END as category FROM members;
    
/* Using the above view to display member category */
SELECT member_id, member_name, category FROM member_category_description;

/* Create a View which contains the information – subject name, title name, 
 * member name, category, issue date, due date and return date. If the 
 * books have not been returned, NULL should be displayed instead of return date */
 CREATE VIEW information_view AS
    SELECT s.subject_name, t.title_name, m.member_name, m.category,
        bi.issue_dt, bi.due_dt, br.return_dt FROM book_issue bi
        INNER JOIN members m ON bi.member_id = m.member_id
        INNER JOIN books b ON bi.accession_number = b.accession_number
        INNER JOIN titles t ON b.title_id = t.title_id
        INNER JOIN subjects s ON t.subject_id = s.subject_id
        LEFT JOIN book_return br ON br.accession_number = bi.accession_number 
            AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt;
 
 /* Using the above view to display the information */
SELECT subject_name, title_name, member_name, category, issue_dt,
    due_dt, return_dt FROM information_view;