REM   Script: Session 02
REM   Session 02


CREATE TABLE salesman(salesman_id int Primary key, salesman_name varchar2(20), salesman_city varchar2(20), commission int);
DESCRIBE salesman;
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
SELECT * FROM salesman;