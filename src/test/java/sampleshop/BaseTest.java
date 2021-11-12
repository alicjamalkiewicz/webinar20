package sampleshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import sampleshop.utils.ScreenshotUtil;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseTest {
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // wyłączenie logowania zbyt dużej informacji przy uruchamianiu drivera
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // zestawienie drivera z wykorzystaniem Web Driver Managera
        // sprawdzana jest wersja przeglądarki w naszym systemie i pobranie odpowiedniej wersji drivera
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // maksymalizacja okna
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sampleshop.inqa.pl/");
    }

    @BeforeMethod
    public void methodSetUp(ITestResult result) {
        // logowanie momentu uruchomienia metody testowej wraz z jej nazwą
        LOGGER.info("Uruchamiam metodę testową " + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void methodTearDown(ITestResult result) {
        LOGGER.info("Kończę metodę testową " + result.getMethod().getMethodName());
        if (result.getStatus() != ITestResult.SUCCESS) {
            LOGGER.warn("Metoda testowa " + result.getMethod().getMethodName() + " zakończona niepowodzeniem");
            System.out.println("Metoda testowa " + result.getMethod().getMethodName() + " zakończona niepowodzeniem");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_hh-mm");
            String readableTimestamp = formatter.format(result.getEndMillis());

            String screenshotPath = "./target/artifacts/screenshots/" + result.getMethod().getMethodName() + "_" + readableTimestamp + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotPath);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}