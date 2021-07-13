DROP TABLE IF EXISTS EMPLOYEE;
 CREATE TABLE EMPLOYEE (
   id bigint PRIMARY KEY,
   person bigint not null,
   position bigint not null,
   salary decimal(16,2) DEFAULT NULL 
  );

DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON (
   id bigint AUTO_INCREMENT PRIMARY KEY not null,
   name VARCHAR(45) NULL,
  last_name VARCHAR(50) NULL,
  address VARCHAR(200) NULL,
  cellphone VARCHAR(60) NULL,
  city_name VARCHAR(50) NULL
  );

DROP TABLE IF EXISTS POSITION; 

  CREATE TABLE POSITION (
   id bigint AUTO_INCREMENT PRIMARY KEY not null,
   name varchar(60) not null
  );

  ALTER TABLE Employee
add CONSTRAINT FK_Persona FOREIGN KEY (person)
    REFERENCES person(id);
   ALTER TABLE Employee
  add CONSTRAINT FK_Position FOREIGN KEY (position)
    REFERENCES `position`(id);  
    
    
    DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
