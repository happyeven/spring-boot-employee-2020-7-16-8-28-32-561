DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS company;
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  gender VARCHAR(10) DEFAULT NULL,
  company_id INT Not NULL
);
INSERT INTO employee (name, age, gender,company_id) VALUES
 ('lmh','18','male',1),
 ('htw','18','male',1);
 CREATE TABLE company (
   company_id INT AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(100) NOT NULL
 );
 INSERT INTO company (name) VALUES('oocl');