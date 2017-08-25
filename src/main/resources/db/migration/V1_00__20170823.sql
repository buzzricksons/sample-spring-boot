DROP TABLE IF EXISTS CITY;
CREATE TABLE CITY (
    id SERIAL,
    name VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    CONSTRAINT CITY_PK PRIMARY KEY (id)
);

INSERT INTO city (name, state, country) VALUES ('San Francisco', 'CA', 'US');