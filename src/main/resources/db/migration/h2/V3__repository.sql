CREATE TABLE province (
  code VARCHAR(6) PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
);

create table city (
  code VARCHAR(6) PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  province_code VARCHAR(6) NOT NULL
);

INSERT INTO province(code, name) VALUES ('430000', '湖南省');
INSERT INTO city(code, name, province_code) VALUES ('430100', '长沙市', '430000');