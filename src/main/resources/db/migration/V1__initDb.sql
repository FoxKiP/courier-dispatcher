CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE tasks (
    id              LONG DEFAULT global_seq.nextval PRIMARY KEY,
    order_id        LONG NOT NULL,
    registered      DATETIME NOT NULL,
    completed       BOOLEAN,
    CONSTRAINT order_id_idx UNIQUE (order_id)
);