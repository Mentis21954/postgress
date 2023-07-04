DROP TABLE users;

CREATE TABLE users (
  	id serial PRIMARY KEY,
	firstname VARCHAR ( 50 ) NOT NULL,
	lastname VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL
);

INSERT INTO users(id, firstname, lastname, email) VALUES (1,'george', 'papadopoulos', 'george@email.com');