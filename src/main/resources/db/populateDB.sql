DELETE
FROM meals;
DELETE
FROM user_roles;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (date_time, description, calories, user_id)
VALUES ('2021-01-31 00:00', 'USER coffee', 50, 100000),
       ('2021-01-30 10:00', 'USER breakfast', 700, 100000),
       ('2021-01-30 13:00', 'USER launch', 1000, 100000),
       ('2021-01-30 18:00', 'USER dinner', 300, 100000),
       ('2021-01-31 10:00', 'USER breakfast', 700, 100000),
       ('2021-01-31 13:00', 'USER launch', 1000, 100000),
       ('2021-01-31 18:00', 'USER dinner', 300, 100000),
       ('2022-01-30 10:00', 'ADMIN breakfast', 700, 100001),
       ('2022-01-30 13:00', 'ADMIN launch', 1000, 100001),
       ('2022-01-30 18:00', 'ADMIN dinner', 300, 100001),
       ('2022-01-31 10:00', 'ADMIN breakfast', 700, 100001),
       ('2022-01-31 13:00', 'ADMIN launch', 1000, 100001),
       ('2022-01-31 18:00', 'ADMIN dinner', 300, 100001),
       ('2022-01-30 00:00', 'ADMIN tea', 50, 100001);