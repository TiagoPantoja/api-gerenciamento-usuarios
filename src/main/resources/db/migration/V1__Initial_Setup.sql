CREATE TABLE departamento (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    departamento_id INT,
    FOREIGN KEY (departamento_id) REFERENCES departamento(id)
);