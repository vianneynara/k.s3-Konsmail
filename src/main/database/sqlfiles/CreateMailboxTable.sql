-- script to create tabele Mailbox
CREATE TABLE Mailbox
(
    uuid            VARCHAR2(36)
        CONSTRAINT mailbox_PK PRIMARY KEY NOT NULL,
    sender_uuid     VARCHAR2(36)
        REFERENCES Accounts (uuid) NOT NULL,
    recipient_uuid  VARCHAR2(36)
        REFERENCES Accounts (uuid) NOT NULL,
    subject         VARCHAR2(128) ,
    content         VARCHAR2(1024), 
    timestamp       TIMESTAMP 
        CONSTRAINT mailbox_timestamp_NN NOT NULL,
    is_flagged      NUMBER(1, 0) NOT NULL,
    is_ad           NUMBER(1, 0) NOT NULL
);