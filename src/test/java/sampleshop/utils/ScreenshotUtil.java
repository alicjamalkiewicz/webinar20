package sampleshop.utils;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    //static private Logger LOGGER = LogManager.getLogger(ScreenshotUtil.class.getName());
    // metoda zwracać będzie true jeśli uda się poprawnie zapisać zrzut ekranu
    public static boolean takeScreenshot(WebDriver driver, String filePath) {
        File simpleShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(simpleShot, new File(filePath));
            //LOGGER.info("Zrzut ekranu pobrany z nazwą " + filePath);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
