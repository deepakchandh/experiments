
CREATE DATABASE IF NOT EXISTS employee_db;
 CREATE TABLE `departments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `department_code` varchar(255) DEFAULT NULL,
  `department_description` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO department (id, department_code, department_description, department_name)
VALUES (1, 'EEE', 'Electronics Engg', 'Electrical');

INSERT INTO department (id, department_code, department_description, department_name)
VALUES (2, 'ECE', 'Electronics Engg', 'Electronics');

INSERT INTO department (id, department_code, department_description, department_name)
VALUES (3, 'CSE', 'computer engg', 'Computer');

INSERT INTO department (id, department_code, department_description, department_name)
VALUES (4, 'civil', 'civil engg', 'civil dept');
