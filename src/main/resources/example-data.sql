TRUNCATE TABLE events, person, company, event_participants;

------ EVENTS ------

INSERT INTO events VALUES
    ('1', 'Aenean commodo', '2022-05-30 10:00:00', 'Tallinn', 'TEST'),
    ('2', 'Fusce ex dui, finibus eu luctus vel', '2025-05-30 10:00:00', 'Tartu', 'TEST'),
    ('3', 'Nunc lobortis metus eu massa viverra ultri iplacerat nibh', '2018-05-30 10:00:00', 'Pärnu', 'TEST'),
    ('4', 'Integer nec nulla vitae', '2022-12-30 10:00:00', 'Valga', 'TEST'),
    ('5', 'Praesent molestie dapibus lorem', '2020-05-30 10:00:00', 'Saaremaa', 'TEST');

------ PERSON ------

INSERT INTO person VALUES
    ('1', 'Mihkel', 'Amman', '37810014694', 'transfer', 'Test person description message'),
    ('3', 'Uku', 'Leele', '37810014944', 'cash', 'Test person description message');

------ COMPANY ------

INSERT INTO company VALUES
    ('2', 'Nullam OÜ', '70000622', 11, 'cash', 'Test company description message');

------ EVENTS_PARTICIPANTS ------

INSERT INTO event_participants VALUES
    ('2', '1'),
    ('2', '2'),
    ('2', '3');