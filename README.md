# Cyber Security Base - Course Project I - Report

Test accounts you can use to test the project are:
Admin user: test, password: test
Normal user: wasd, password: wasd

## Issue: A3-Cross-Site Scripting (XSS)
**Steps to reproduce:**

1. Sign in with test account
2. Click button "Signup for an event"
3. Input " <script>alert("Hello!");</script> " to the name field and some text to address field
4. Submit form
5. You can see that the javascript gets executed when you see the alert

**How to fix:**

The flaw can be fixed by using th:text instead of th:utext in event_signups.html when displaying text with Thymeleaf.

## Issue: A5-Security Misconfiguration
**Steps to reproduce:**
1. 

**How to fix:**


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

