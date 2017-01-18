# Cyber Security Base - Course Project I - Report

Test accounts you can use to test the project are:
Admin user: test, password: test
Normal user: wasd, password: wasd

For every issue the prerequisite is that the application is running and the server is started. The default address and port for the server is http://localhost:8080

## Issue: A3-Cross-Site Scripting (XSS)
**Steps to reproduce:**

1. Sign in with one of the test account
2. Click button "Signup for an event"
3. Input " < script>alert("Hello!");< /script> " to the name field and some text to address field (remove space character from between "<" and "s" and and "/" from script-tags)
4. Submit form
5. You can see that the javascript gets executed when you see the alert

**How to fix:**

The flaw can be fixed by using th:text instead of th:utext in event_signups.html when displaying text with Thymeleaf.

## Issue: A5-Security Misconfiguration
**Steps to reproduce:**

1. Sign in with one of the test accounts 
2. Open developer console in your browser (For example like [this](https://developers.google.com/web/tools/chrome-devtools/console/))
3. Write document.cookie to the console and press enter
4. You can see the JSESSIONID of your session

**How to fix:**

The flaw can be fixed by setting context.setUseHttpOnly(false) to context.setUseHttpOnly(true) in class ApplicationConfiguration so you cannot access the cookies anymore through JavaScript.

## Issue: A7-Missing Function Level Access Control
**Steps to reproduce:**

1. Get Postman (for example in Chrome from [here](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop))
2. Start Postman
3. Send following requests to server. You can send a request like this:
  1. Input the address to "Enter request URL" -field
  2. Select right HTTP method (GET or POST) from dropdown
  3. In POST-requests select "Body"-tab and select "form-data" from radio buttons and set data by giving key and value pairs

##### Requests:

	1. POST http://localhost:8080/login 
	Body: (pairs represent <key> <value> pairs)
	username wasd
	password wasd 
  
  --> You are now logged in as normal user "wasd" who should not be able to remove signups
  
  	2. POST http://localhost:8080/eventsignups
	Body:
	name test
	address test
  
  --> You can see that signup was registered for "test"
  
 	3. POST http://localhost:8080/eventsignups
	Body:
	name test2
	address test2
  
  --> You can see new signup for "test2"
  
  	4. GET http://localhost:8080/eventsignups
  
  --> You can see that response still contains 2 signups
  
  	5. POST http://localhost:8080/eventsignups/delete
	Body:
	name test2
	address test2
  
  --> You can see that "test2" signup was removed from the signups even though user "wasd" should not be able to remove signups
  
  	6. GET http://localhost:8080/eventsignups
  
  --> You can verify that the "test2" signup is removed and that the user "wasd" cannot see the delete buttons 
  

**How to fix:**

The flaw can be fixed by adding @PreAuthorize("hasAuthority('ROLE_ADMIN')") annotation to EventSignupService removeEventSignup()-method.
You can verify that the fix works by repeating the above steps with Postman after restarting the application. After step 5. you will get response with status code 403 Forbidden.

## Issue: A8-Cross-Site Request Forgery (CSRF)
**Steps to reproduce:**

1. Go to the address http://localhost:8080
2. Open developer tools Network tab in your browser (For example like [this](https://developers.google.com/web/tools/chrome-devtools/network-performance/resource-loading))
3. Sign in with one of the test accounts 
4. You should see one POST-request in the network tab
5. Click the name of the POST-request "login" and select "Headers"-tab
6. Scroll down in the headers so tab you can see "Form data"-information
7. If CSRF protection were enabled you should see _csrf-token_ there but now you cannot see that token 

**How to fix:**

The flaw can be fixed by removing line "http.csrf().disable();" from class SecurityConfiguration.

## Issue: A9-Using Components with Known Vulnerabilities
**Steps to reproduce:**
1. 

**How to fix:**

