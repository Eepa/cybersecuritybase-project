# Cyber Security Base - Course Project I - Report

Test accounts you can use to test the project are:
Admin user: test, password: test
Normal user: wasd, password: wasd

## Issue: A3-Cross-Site Scripting (XSS)
**Steps to reproduce:**

1. Sign in with test account
2. Click button "Signup for an event"
3. Input " < script>alert("Hello!");</script > " to the name field and some text to address field (remove space character from between "<" and "s" and "t" and ">" from script-tags)
4. Submit form
5. You can see that the javascript gets executed when you see the alert

**How to fix:**

The flaw can be fixed by using th:text instead of th:utext in event_signups.html when displaying text with Thymeleaf.

## Issue: A5-Security Misconfiguration
**Steps to reproduce:**

1. Sign in with test account 
2. Open developer console in your browser (For example like [this](https://developers.google.com/web/tools/chrome-devtools/console/)
3. Write document.cookie to the console and press enter
4. You can see the JSESSIONID of your session

**How to fix:**

The flaw can be fixed by setting context.setUseHttpOnly(false) to context.setUseHttpOnly(true) in class ApplicationConfiguration so you cannot access the cookies anymore through JavaScript.

## Issue: A7-Missing Function Level Access Control
**Steps to reproduce:**
1. 

**How to fix:**


## Issue: A8-Cross-Site Request Forgery (CSRF)
**Steps to reproduce:**
1. 

**How to fix:**


## Issue: A9-Using Components with Known Vulnerabilities
**Steps to reproduce:**
1. 

**How to fix:**

