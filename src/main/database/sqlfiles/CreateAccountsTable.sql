-- script to create table Accounts
CREATE TABLE Accounts
(
    uuid          VARCHAR2(36)
        CONSTRAINT accounts_PK PRIMARY KEY NOT NULL,
    email_address VARCHAR2(255),
    password      VARCHAR2(128)
                                           NOT NULL,
    first_name    VARCHAR2(50)
        CONSTRAINT accounts_first_name_NN NOT NULL,
    last_name     VARCHAR2(50)
        CONSTRAINT accounts_last_name_NN NOT NULL
);