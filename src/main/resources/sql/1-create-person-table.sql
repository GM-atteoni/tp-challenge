--liquibase formatted sql

--changeset pepe:1
CREATE TABLE Person (
	id serial PRIMARY KEY,
	name VARCHAR,
	age VARCHAR,
	gender VARCHAR
);