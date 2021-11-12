package sampleshop.pages;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
ZADANIE DOMOWE:
- dodanie możliwości wskazania ilości produktów
- sprawdzić czy dodało do koszyka: tylko modal + komunikat "Produkt dodany poprawnie do Twojego koszyka"
 */
public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static WebElement modalView;

    @FindBy(css = "button[data-button-action='add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(css = "select#group_1")
    private WebElement sizeSelect;
    @FindBy(xpath = "//h4[contains(text(), 'Produkt dodany poprawnie do Twojego koszyka')]")
            //(xpath = "//*[text()[contains(.,'Produkt dodany poprawnie do Twojego koszyka')]]")

    public WebElement productAddedMessage;


    public void selectSize(String sizeToSelect) {
        LOGGER.info("Wybieram rozmiar " + sizeToSelect);
        Select sizeSelectElement = new Select(sizeSelect);
        sizeSelectElement.selectByVisibleText(sizeToSelect);
    }

    public void clickAddToCartButton() {
        LOGGER.info("Klikam button dodawania do koszyka");
        buttonClick(addToCartButton);
    }

    public void selectColor(String colorName) {
        LOGGER.info("Wybieram kolor " + colorName);
        WebElement selectedColorElement = driver.findElement(By.xpath("//input[@class='input-color' and @title='" + colorName + "']"));
        selectedColorElement.click();
    }

    public void addQuantity(){
        WebElement addQuantityButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i"));
        addQuantityButton.click();
    }
     public boolean modalViewAppears(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         modalView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"blockcart-modal\"]/div/div")));
         return true;
     }
}
///html/body/div[1]/div/div/div[1]/h4/text()