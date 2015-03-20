-- Drop database
DROP DATABASE ios;

-- Database Create for MySql database
CREATE DATABASE ios;

-- changing database
USE ios;

--DROP table
DROP TABLE search_data;


-- Table creation
CREATE TABLE search_data (
	id INTEGER(4) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	address VARCHAR(50) NOT NULL,
	phone VARCHAR(10),
	search_type VARCHAR(20) NOT NULL,
	place VARCHAR(20) NOT NULL,
	CONSTRAINT search_data_id_pk PRIMARY KEY (id)
);

ALTER TABLE search_data AUTO_INCREMENT = 1001;

-- DROP table
DROP TABLE saved_data; 

CREATE TABLE saved_data (
	id INTEGER(4) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	address VARCHAR(50) NOT NULL,
	phone VARCHAR(10),
	search_type VARCHAR(20) NOT NULL,
	place VARCHAR(20) NOT NULL,
	CONSTRAINT saved_data_id_pk PRIMARY KEY (id)
);

ALTER TABLE saved_data AUTO_INCREMENT = 5001;



-- INSERT
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Hana Japanese restaurant','1381 London Rd,Sarnia, ON','5193368188','restaurant','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Olives','1591 London Line,Sarnia, ON','5195411333','restaurant','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Waggs Steak & Seafood','420 Christina St N,Sarnia, ON','5193444422','restaurant','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Maison St-Aubin','1202 Lakeshore Rd,Sarnia, ON','5195429507','restaurant','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Ciccios Place','869 Exmouth St,Sarnia, ON','5193373711','restaurant','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Paddy Flahertys Irish','130 Seaway Road, Sarnia, ON N7T 8A5','5193361999','pub','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Prime Pubs','130 Seaway Road, Sarnia, ON N7T 8A5','5193361999','pub','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('Ups N Downs','226 Front St N, Sarnia, Ontario','5193360337','pub','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('LCBO','1450 Quinn Drive,Sarnia, ON','5195426836','lcbo','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('LCBO Sarnia','1142 Lakeshore Rd,Sarnia, ON','5195427410','lcbo','sarnia');
INSERT INTO search_data (name,address,phone,search_type,place) VALUES ('LCBO','408 Lyndoch St,Corunna, ON','5198623456','lcbo','sarnia');



INSERT INTO saved_data (name,address,phone,search_type,place) VALUES ('Hana Japanese restaurant','1381 London Rd,Sarnia, ON','5193368188','restaurant','sarnia');
INSERT INTO saved_data (name,address,phone,search_type,place) VALUES ('Prime Pubs','130 Seaway Road, Sarnia, ON N7T 8A5','5193361999','pub','sarnia');
