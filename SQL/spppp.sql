CREATE TABLE continents
(
    continent_id      NUMBER          NOT NULL, 
    continent_name    VARCHAR2(50)    NOT NULL, 
    CONSTRAINT CONTINENTS_PK PRIMARY KEY (continent_id)
);

CREATE SEQUENCE continents_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TABLE locations
(
    location_id            NUMBER          NOT NULL, 
    location_name          VARCHAR2(50)    NOT NULL, 
    location_state_name    VARCHAR2(50)    NULL, 
    continent_id           NUMBER          NOT NULL, 
    CONSTRAINT LOCATIONS_PK PRIMARY KEY (location_id)
);

CREATE SEQUENCE locations_SEQ
START WITH 10
INCREMENT BY 10;


ALTER TABLE locations
    ADD CONSTRAINT FK_locations_continent_id_cont FOREIGN KEY (continent_id)
        REFERENCES continents (continent_id);
        
CREATE TABLE departments
(
    department_id      NUMBER          NOT NULL, 
    department_name    VARCHAR2(20)    NOT NULL, 
    location_id        NUMBER          NOT NULL, 
    CONSTRAINT DEPARTMENTS_PK PRIMARY KEY (department_id)
);

CREATE SEQUENCE departments_SEQ
START WITH 100
INCREMENT BY 100;

ALTER TABLE departments
    ADD CONSTRAINT FK_departments_location_id_loc FOREIGN KEY (location_id)
        REFERENCES locations (location_id);