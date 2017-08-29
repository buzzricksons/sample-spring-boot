DROP TABLE IF EXISTS TCITY;
CREATE TABLE TCITY (
    id SERIAL,
    name VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    CONSTRAINT CITY_PK PRIMARY KEY (id)
);

INSERT INTO tcity (name, state, country) VALUES ('San Francisco', 'CA', 'US');