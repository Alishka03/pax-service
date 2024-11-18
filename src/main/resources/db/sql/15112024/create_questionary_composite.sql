CREATE TABLE if not exists questionary_composite
(
    _sys_terminalid VARCHAR(255) NOT NULL,
    pos_id         VARCHAR(255) NOT NULL,
    event_time     TIMESTAMPTZ,
    PRIMARY KEY (_sys_terminalid, pos_id)
);
