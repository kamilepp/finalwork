package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Driver;

import java.io.File;
import java.util.UUID;

public class TestListener implements ITestListener {

    private void takeScreenshot (){
        try {
            TakesScreenshot takeScreenshot = ((TakesScreenshot) Driver.getDriver());
            File screenshotRaw = takeScreenshot.getScreenshotAs(OutputType.FILE);

            String directory = "./screenshots";
            File screenshotFile = new File(directory + "/screenshot-" + UUID.randomUUID() + ".png");
            FileUtils.copyFile(screenshotRaw, screenshotFile);

        }catch (Exception ex){
            System.out.println("Exception while taking a screenshot: " + ex);
        }

    }
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }
}
