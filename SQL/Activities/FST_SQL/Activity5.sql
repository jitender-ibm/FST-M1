REM   Script: Session 05
REM   Session 05

CREATE TABLE salesman(salesman_id int Primary key, salesman_name varchar2(20), salesman_city varchar2(20), commission int);
DESCRIBE salesman

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES ('5001', 'James Hoog', 'New York',    '15');

INSERT ALL  
    INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES    ('5002', 'Nail Knite', 'Paris',    '13')  
    INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES    ('5005', 'Pit Alex', 'London',    '11')  
    INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES    ('5006', 'McLyon', 'Paris',    '14')  
    INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES    ('5007', 'Paul Adam', 'Rome',    '13')  
    INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
	VALUES    ('5003', 'Lauson Hen', 'San Jose',    '12')  
    SELECT 1 FROM dual;

ALTER TABLE salesman ADD salesman_age int;
UPDATE salesman SET salesman_age='35' ;
ALTER TABLE salesman RENAME COLUMN salesman_age to grade;
UPDATE salesman SET grade='100';
UPDATE salesman SET grade='200' WHERE salesman_city = 'Rome';
UPDATE salesman SET grade= '300' WHERE salesman_name = 'James Hoog';
UPDATE salesman SET salesman_name = 'Pierre' WHERE salesman_name = 'McLyon';
SELECT * FROM salesman salesman;