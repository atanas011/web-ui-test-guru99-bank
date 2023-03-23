### Guru99 Bank Test

Java (JDK) and Maven should be installed and added to System variables.  
Tests were written to run with Microsoft Edge browser.

- Clone repo to local dir and open cmd.exe in it
- To get results only, run: mvn test
- To get results and HTML report, run: mvn surefire-report:report
- Report is created in: target/site/surefire-report.html

To get access to test site:

* Visit http://demo.guru99.com, enter your Email ID and submit
* Login credentials are sent to your email (they are valid for 20 days)

User story:

1. Go to https://www.demo.guru99.com/V4
2. Enter invalid UserId and invalid Password / invalid UserId and valid Password / valid UserId and invalid Password
3. Click Login
4. Verify alert text
5. Enter valid UserId and valid Password
6. Click Login
7. Verify ManagerID shown in Welcome message on result page