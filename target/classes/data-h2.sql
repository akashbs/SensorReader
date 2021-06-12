INSERT INTO CITY(id, name)
VALUES (1, 'Barcelona');
INSERT INTO CITY(id, name)
VALUES (2, 'Wien');
INSERT INTO CITY(id, name)
VALUES (3, 'Munchen');

INSERT INTO DISTRICT(id, name, city_id)
VALUES (1, 'Gràcia', 1);
INSERT INTO DISTRICT(id, name, city_id)
VALUES (2, 'Eixample', 1);
INSERT INTO DISTRICT(id, name, city_id)
VALUES (3, 'Währing', 2);
INSERT INTO DISTRICT(id, name, city_id)
VALUES (4, 'Penzing', 2);
INSERT INTO DISTRICT(id, name, city_id)
VALUES (5, 'Maxvorstadt', 3);

INSERT INTO SENSOR(id, district_id)
VALUES (1, 1);
INSERT INTO SENSOR(id, district_id)
VALUES (2, 2);
INSERT INTO SENSOR(id, district_id)
VALUES (3, 3);
INSERT INTO SENSOR(id, district_id)
VALUES (4, 4);
INSERT INTO SENSOR(id, district_id)
VALUES (5, 5);

