-- README: open "Run SQL Command Line" and execute the following commands:
-- connect as administrator
CONN sya as sysdba;

-- creates the user specifically for the project
CREATE USER usip2pbol IDENTIFIED BY usip2pbol;

-- grants all privileges to the user
GRANT ALL PRIVILEGES TO usip2pbol;
