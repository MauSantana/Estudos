/* CREATE USER 'maysa'@'200.200.190.190' IDENTIFIED BY 'bob123';
CREATE USER 'maysa'@'%' IDENTIFIED BY 'bob123'; */
CREATE USER 'maysa'@'localhost' IDENTIFIED BY 'bob123';
GRANT ALL ON curso_sql.* TO 'maysa'@'localhost';

CREATE USER 'maysa'@'%' IDENTIFIED BY 'bobdoido123';
GRANT SELECT ON curso_sql.* TO 'maysa'@'%';
GRANT INSERT ON curso_sql.funcionarios TO 'maysa'@'%';

REVOKE INSERT ON curso_sql.funcionarios FROM 'maysa'@'%';

DROP USER 'maysa'@'%';
DROP USER 'maysa'@'localhost';

SELECT USER FROM MYSQL.USER;
SHOW GRANTS FOR 'maysa'@'localhost';