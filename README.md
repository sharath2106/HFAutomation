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
 **Congrats!** Now you are up and running!
 
 *Watch Live Execution in Selenium GRID* - http://localhost:4444/grid/admin/live/ 
 *Watch Recorded Execution video* http://localhost:4444/dashboard/# 
 
### Reporting

Cluecumber is used as the reporting tool for the test execution results. The advantages of Cluecumber are the following - 
  - *It is a simple reporting plugin in Maven and configuration of the same is just a matter of minutes*
  - *No need to touch even a single line of code to configure unlike Extent reports* ```(Take a look at the commit - 3cf7379bda5128b4a9acad1ddaf76c4da33f90d3)```
  - *Simple and clutter free reporting*

### Logging

Log4J is used as the logging library for the framework. The logging levels are  set to DEBUG and I've predominantly used INFO and ERROR level logs. The logger type is RollingFileAppender, this covers the entire lifecycle of test execution and logs the details in the destination file.

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions

### Todos

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

