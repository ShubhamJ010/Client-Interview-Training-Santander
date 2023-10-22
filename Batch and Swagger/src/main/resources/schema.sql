DROP TABLE USERS IF EXISTS;

CREATE TABLE USERS (
    id BIGINT  GENERATED ALWAYS AS IDENTITY,
    user_id VARCHAR(50) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    primary key(user_id));