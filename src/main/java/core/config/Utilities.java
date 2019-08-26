package core.config;

import core.config.webdriver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
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

    public void takeScreenshotsForFailedTests(ITestResult result){
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        Date date = new Date();
        String methodNameOfTest = result.getName().trim();
        File sourceFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(pathToFailedScreenshotsReport+methodNameOfTest+date.getTime()+".png"));
        } catch (IOException e) {
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
            ex.printStackTrace();
        }
    }

    public String getProperty(String pathToPropertiesFile, String propertiesToGet){
        Properties properties =  new Properties();
        try {
            properties.load(new FileInputStream(pathToPropertiesFile));
        } catch (IOException e) {
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
