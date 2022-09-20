
# Cucumber TestNG Selenium
#Environment Setup

1. Install JRE 16 with java path set to runtime: /Library/Java/JavaVirtualMachines/jdk-16.0.1.jdk/Contents/Home
2. Install maven (On mac - recommend home brew)
3. Install Eclipse
4. Set the Maven and Java Home Paths

##Testing on Physical iPhone
1. Ensure the iphone is connected to Mac
2. Install Appium - refer https://appium.io/docs/en/drivers/mac/
3. Start appium or run "appium --reboot" in terminal

#Running the scripts from Terminal/CLI

1. Ensure all the Prerequisites as metioned in the #Environment Setup are completed
2. run $mvn clean test

This would trigger the maven surefire plugin, since pom.xml has already been updated with testNG.xml in the project directory, the feature files defined in the testng.xml should run and appropriate results should be shown in the terminal 

#Running from Eclipse
1. Open the project in eclipse
2. TestRunner files are in "./src/main/java/MyRunner"
3. Choose the appropriate test runner and run them as testng test

## Access Reports
1. Reports are stored in "./CucumberReports"
2. Ensure to copy the CucumberReports along with ""./Screenshots" - else the report would have broken images

Important points:
1. Update the App version uploaded to browser stack in "./src/resources/configs/BrowserStackConfig"
2. Can change the target test environment in the "./src/resources/configs/EnvironmentDetails"
3. For testing on physical iPhone - ensure the latest ipa's are stored in "mobile-automation/src/resources/files_ipa"
4. Latest Chromedriver is stored in "./src/resources/Drivers"

##Issue and solutions
1. Chrome driver version do not match the current chrome version installed
  Solution: Download and replace the latest chrome driver from https://chromedriver.chromium.org/downloads
2. Chrome driver certificate is not valid/validated
  Solution: Run "xattr -d com.apple.quarantine {path/to/chromedriver}" in terminal. This will quarantine the chromedriver
