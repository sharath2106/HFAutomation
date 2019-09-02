# HelloFresh Automation task

In this project, I have created a Selenium Test framework with a combination of java-maven project with Cucumber and using TestNG executed on firefox and chrome dockers.

The task automates the following testcases in the application - 

  - SignUp a new user by registering into the application 
  - Login to the application
  - Purchase a product from the application after login

This project has leveraged the use of Zalenium, which is a Selenium Grid extension to scale your local grid dynamically with docker containers. It uses docker-selenium to run your tests in Firefox and Chrome locally.

### List of Tools/Libraries used -

The automation framework used for the task uses the following languages/tools to work properly:

* [Java] - Programming language used for the framework
* [TestNG] - Testing framework used for execution of tests
* [Cucumber] - BDD tool used for scenario creation and understanding
* [Maven] - Build tool to download and use dependencies for the project
* [Zalenium] - Selenium Grid with browsers spinning up in docker.
* [Log4J] - Logging library used for every action
* [Lombok] - Java library used for Getters, Setters and Constructors (*pojo creator*)
* [WebdriverManager] - Library used to automate the management of binary drivers
* [Jackson YAML] - Used as Dataproviders for pojo classes
* [Cluecumber] - Maven plugin used to generate reports for the tests
        
### How to run the tests?

*Execute the following commands to run the tests in the desired environment.*

Clone the repository - https://github.com/sharath2106/HFAutomation.git

```sh
# Get into the directory
$ cd HelloFresh-Automation
```
Open any IDE of your choice and "Enable Annotation Processing" for Lombok to work
```sh
# Execute the following commands to set up Zalenium
$ docker pull elgalu/selenium

$ docker pull dosel/zalenium

$ docker run --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start


# Run tests in the chosen environment (here we have selected - QA)
$ mvn clean test -Denvironment=QA
```
 **Congrats!** Now your tests are up and running!
 
 *Watch Live Execution in Selenium GRID* - http://localhost:4444/grid/admin/live/ 
 
 *Watch Recorded Execution video* http://localhost:4444/dashboard/# 
 
### Reporting

*Cluecumber is used as the reporting tool for the test execution results. The advantages of Cluecumber are the following -*
  - It is a simple reporting plugin in Maven and configuration of the same is just a matter of minutes
  - No need to touch even a single line of code to configure unlike Extent reports ```(Take a look at the commit - 3cf7379bda5128b4a9acad1ddaf76c4da33f90d3)```
  - Simple and clutter free reporting
  
  

 ``` sh
 # To generate the report, run the following command after test execution
 $ mvn cluecumber-report:reporting
 ```

Find the report generated under the target -> generated-report directory named as "index.html" as below -
 
<img width="219" alt="Screenshot 2019-08-30 at 11 10 18 AM" src="https://user-images.githubusercontent.com/25933070/63995605-c537d380-cb16-11e9-960a-6a34c4c9c6d0.png">
<img width="1680" alt="Screenshot 2019-08-30 at 11 08 07 AM" src="https://user-images.githubusercontent.com/25933070/63995559-94f03500-cb16-11e9-9a91-f4520829137c.png">
<img width="990" alt="Screenshot 2019-08-30 at 11 08 23 AM" src="https://user-images.githubusercontent.com/25933070/63995561-96b9f880-cb16-11e9-8c6e-f2496deb0ffd.png">


### Logging

Log4J is used as the logging library for the framework. 

The logging levels are  set to DEBUG and I've predominantly used INFO and ERROR level logs. 

The logger type is RollingFileAppender, this covers the entire lifecycle of test execution and logs the details into the destination file as shown below -

<img width="626" alt="Screenshot 2019-08-30 at 11 14 45 AM" src="https://user-images.githubusercontent.com/25933070/63995795-66268e80-cb17-11e9-9e27-aba147e1660f.png">

Logs are generated under the "logs" directory of the project named as "debug-log.log" as shown below -

<img width="150" alt="Screenshot 2019-08-30 at 11 13 53 AM" src="https://user-images.githubusercontent.com/25933070/63995764-498a5680-cb17-11e9-9c09-ca22aac220d3.png">

### Screenshots

The screen is captured for every failure of the test execution. This is set under the onTestFailure method of the TestNG listener in the framework. 

The screenshots are generated under target -> failed-tests-screenshots directory as shown below -

<img width="298" alt="Screenshot 2019-08-30 at 11 31 19 AM" src="https://user-images.githubusercontent.com/25933070/63996598-ba327280-cb19-11e9-844d-cb3af1c38f81.png">

### Checklist

- [x] Logging
- [x] Screenshots for failed tests
- [x] Generating human readable report
- [x] Generating random values for insignificant data
- [ ] WebDriver factory
- [x] Encapsulation layers like test data, logic and actions on pages
- [x] Run tests in Parallel mode
- [x] Ability to run tests in different browsers
- [x] Ability to run tests in different environments 
- [ ] Reading test data from file in Checkout tests

### "Nice to have" that can be done

- *Execution of tests in multiple Operating systems*

> This can be acheived by executing the tests in BrowserStack or SauceLabs environment in the project. The execution platform can be passed as a parameter through maven command.

- *Integration of test scenario with test cases of any test management tool*

> We can integrate the test execution status with a test management tool like Zephyr using ZAPI. 
