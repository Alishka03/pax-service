CREATE TABLE if not exists cashier_mode
(
    id bigserial primary key,
    _sys_terminalid
    VARCHAR, -- Terminal SN
    _sys_resellerid
    VARCHAR, -- Reseller
    _sys_merchantid
    VARCHAR, -- Merchant
    pos_id
    VARCHAR, -- POSID
    psp_version
    VARCHAR, -- PSP Version
    enable_cashier_mode
    VARCHAR, -- Enable Cashier Mode
    _eventtime
    VARCHAR
    -- Event Time
);
