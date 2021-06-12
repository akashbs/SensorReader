CREATE TABLE CITY
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);
CREATE TABLE DISTRICT
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255),
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES CITY
);
CREATE TABLE SENSOR
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    district_id INT NOT NULL,
    FOREIGN KEY (district_id) REFERENCES DISTRICT
);
CREATE TABLE SENSOR_READING
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    sensor_id      INT      NOT NULL,
    carbon_reading FLOAT    NOT NULL,
    timestamp      DATETIME NOT NULL,
    FOREIGN KEY (sensor_id) REFERENCES SENSOR
);