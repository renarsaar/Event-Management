-- ------ EVENTS ------

CREATE TABLE IF NOT EXISTS events (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    eventTime VARCHAR(32) NOT NULL,
    eventLocation VARCHAR(255) NOT NULL,
    description TEXT(1000) NOT NULL
);

-- ------ PARTICIPANT ------

CREATE TABLE IF NOT EXISTS participant {
    id INT NOT NULL PRIMARY KEY,

    paymentType VARCHAR(32) NOT NULL,
    description VARCHAR TEXT(1500)
}

CREATE TABLE IF NOT EXISTS event_participants {
    event_id VARCHAR(64) NOT NULL,
    participant_id VARCHAR(64) NOT NULL,
    PRIMARY KEY (event_id, participant_id)
}

-- ------ PERSON ------

CREATE TABLE IF NOT EXISTS person {
    id INT NOT NULL PRIMARY KEY,
    firstName VARCHAR(64) NOT NULL,
    lastName VARCHAR(64) NOT NULL,
    personalCode VARCHAR(11) NOT NULL,
    paymentType VARCHAR(32) NOT NULL,
    description VARCHAR TEXT(1500)
}

-- ------ COMPANY ------

CREATE TABLE IF NOT EXISTS company {
    id INT NOT NULL PRIMARY KEY,
    registryCode VARCHAR(32) NOT NULL,
    numberOfPartakers INT NOT NULL,
    paymentType VARCHAR(32) NOT NULL,
    description VARCHAR TEXT(5000)
}