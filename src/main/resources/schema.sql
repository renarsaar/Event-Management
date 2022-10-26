-- ------ EVENTS ------

CREATE TABLE IF NOT EXISTS event (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    event_time VARCHAR(32) NOT NULL,
    event_location VARCHAR(255) NOT NULL,
    description TEXT(1000) NOT NULL
);

-- ------ PERSON ------

CREATE TABLE IF NOT EXISTS person (
    id INT NOT NULL PRIMARY KEY,
    event_id VARCHAR(64) NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    personal_code VARCHAR(11) NOT NULL,
    payment_type VARCHAR(32) NOT NULL,
    description TEXT(1500) NOT NULL
);

-- ------ COMPANY ------

CREATE TABLE IF NOT EXISTS company (
    id INT NOT NULL PRIMARY KEY,
    event_id VARCHAR(64) NOT NULL,
    legal_name VARCHAR(255) NOT NULL,
    registry_code VARCHAR(32) NOT NULL,
    number_of_partakers INT NOT NULL,
    payment_type VARCHAR(32) NOT NULL,
    description TEXT(5000) NOT NULL
);