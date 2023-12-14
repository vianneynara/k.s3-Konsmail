BEGIN
    INSERT INTO MAILBOX
    VALUES ('2eb264a1-380c-41f3-89e5-d6e29e5d09c3',
            '04ff211d-ce06-4203-9893-7050f6a6e66b',
            'f6e94d2b-7a44-42ba-aa4b-d7792d67eda6',
            'Hey let''s play lethal company',
            'Yo you free? me and my buddies will play a game called Lethal Ccompany tonight at 8:00 PM! let''s get them quota together dude!',
            TO_DATE('2023-12-14 18:15:11', 'YYYY-MM-DD HH24:MI:SS'),
            0,
            0);

    INSERT INTO MAILBOX
    VALUES ('5eb264a1-380c-41a3-89e5-d6e29e5d09c3',
            'f6e94d2b-7a44-42ba-aa4b-d7792d67eda6',
            '04ff211d-ce06-4203-9893-7050f6a6e66b',
            'Sure let''s play lethal company',
            'add me on discord!',
            TO_DATE('2023-12-14 18:20:00', 'YYYY-MM-DD HH24:MI:SS'),
            0,
            0);

    COMMIT;
END;