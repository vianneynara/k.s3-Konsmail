CREATE TABLE Accounts
(
    uuid          VARCHAR2(36)
        CONSTRAINT accounts_PK PRIMARY KEY          NOT NULL,
    email_address VARCHAR2(255)
        CONSTRAINT accounts_email_address_UK UNIQUE NOT NULL,
    password      VARCHAR2(128)
                                                    NOT NULL,
    first_name    VARCHAR2(50)
        CONSTRAINT accounts_first_name_NN NOT NULL,
    last_name     VARCHAR2(50)
        CONSTRAINT accounts_last_name_NN NOT NULL
)

DROP TABLE Accounts;