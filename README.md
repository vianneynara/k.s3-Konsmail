# Konsmail (Mailing App)

## What is Konsmail?

This is a simple mailing app that allows you to send emails to multiple recipients at once. It is built using Java.
The app is built for the purpose of final project of the course "Object-Oriented Programming 2". The database structure
is stored locally using an Oracle database.

## Project Structure

```
src
└── main                    
    ├── database                    # Contains database files
    │   ├── driver                  # Contains the driver used to connect to the database
    │   └── sqlfiles                # Contains SQL files used to create the database needs
    ├── java        
    │   ├── gui                     # Contains GUI files
    │   ├── models      
    │   │   ├── objects             # Contains objects used in the app
    │   │   └── views               # Contains views used in the app
    │   │       └── inboxtable      # Contains classes required for inbox table
    │   ├── utils                   # Contains utility files
    │   └── Konsmail.java           # Main runner class
    └── resources                   
        └── images                  # Contains images used in the app
```

## GUI Preview

The main window is not resizable, the resolution is fixed at 1366x768.

### Login Page

<p style="text-align: center">
  <img src="images/login_page.png" alt="Login Page" width="400"/>
</p>

### Registration Page

<p style="text-align: center">
  <img src="images/registration_page.png" alt="Login Page" width="400"/>
</p>

### Mailbox Page

<p style="text-align: center">
  <img src="images/mailbox_page.png" alt="Login Page" width="650"/>
</p>

### Configure Account Page

<p style="text-align: center">
  <img src="images/configure_account_page.png" alt="Login Page" width="400"/>
</p>

### New Mail Page

<p style="text-align: center">
  <img src="images/new_mail_page.png" alt="Login Page" width="400"/>
</p>

## Contributors

These are the people who contributed to the project:

| Nr | Name                                    | NIM  |
|----|-----------------------------------------|------|
| 1  | [Nara](https://github.com/vianneynara)  | -091 |
| 2  | [Edward](https://github.com/Trustacean) | -067 |
| 3  | [Patrick](https://github.com/FatDog98)  | -078 |
