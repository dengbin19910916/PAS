CREATE TABLE person (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30)
);

INSERT INTO person(id, first_name, last_name)
VALUES (1, '邓', '斌'), (2, '向', '嘉怡');