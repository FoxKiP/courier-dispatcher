DELETE FROM tasks;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO tasks (order_id, registered, completed)
VALUES ( 584673, '2020-11-15 10:30', false),
       ( 476293, '2020-11-14 14:18', false),
       ( 9283, '2020-11-13 16:23', false);