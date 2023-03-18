### Guru99 Bank Test

Java (JDK) and Maven should be installed and added to System variables.  
Tests were written to run with Microsoft Edge browser.

- Clone repo to local dir and open cmd.exe in it
- To get results only, run: mvn test
- To get results and HTML report, run: mvn surefire-report:report
- Report is created in: target/site/surefire-report.html


To get access to test site:

* Visit http://demo.guru99.com, enter your email id and submit
* Login credentials are sent to your email (they are valid for 20 days)

User story:

1. Go to https://www.demo.guru99.com/V4
2. Enter valid UserId
3. Enter valid Password
4. Click Login
5. Verify successful login