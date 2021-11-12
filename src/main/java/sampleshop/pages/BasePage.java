package sampleshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.Duration;

public class BasePage {
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Tutaj umieszczamy metody, które są wspólne dla różnych stron
    // mogą to być operacje na typowych elementach (input, button)
    // wspólne operacje wait

    protected void buttonClick(WebElement buttonElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonElement));

        buttonElement.click();
    }

    private void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
