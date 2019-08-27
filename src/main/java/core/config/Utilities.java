package core.config;

import core.config.webdriver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import static core.config.Constant.pathToFailedScreenshotsReport;

public class Utilities {

    private Logger logger;


    public Utilities() {
        logger = Logger.getRootLogger();
    }

    public void takeScreenshotsForFailedTests(ITestResult result){
        Date date = new Date();
        String methodNameOfTest = result.getName().trim();
        File sourceFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(pathToFailedScreenshotsReport + methodNameOfTest + " - " + date.getTime() + ".png"));
        } catch (IOException e) {
            logger.error("Failed to take screenshot");
            e.printStackTrace();
        }
    }

    public void deleteScreenshotsFolderFromProject(){
        try {
            File file = new File(pathToFailedScreenshotsReport);
            String[] entriesInFolder = file.list();
            if (entriesInFolder != null) {
                for (String s : entriesInFolder) {
                    File currentFile = new File(file.getPath(), s);
                    currentFile.delete();
                }
                file.delete();
            }
        } catch (Exception ex) {
            logger.error("Failed to delete screenshots files/folder");
            ex.printStackTrace();
        }
    }

    public String getProperty(String pathToPropertiesFile, String propertiesToGet){
        Properties properties =  new Properties();
        try {
            properties.load(new FileInputStream(pathToPropertiesFile));
        } catch (IOException e) {
            logger.error("Failed to fetch property from file");
            e.printStackTrace();
        }
        return properties.getProperty(propertiesToGet);
    }

    public String getRandomString(int sizeOfString){
        return RandomStringUtils.randomAlphabetic(sizeOfString).toLowerCase();
    }

    public String getRandomNumber(int sizeOfNumber){
        return RandomStringUtils.randomNumeric(sizeOfNumber);
    }

    public String getRandomAlphanumeric(int sizeOfAlphanumerics){
        return RandomStringUtils.randomAlphanumeric(sizeOfAlphanumerics);
    }
}
