package sampleshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        // wykorzystanie konstruktora z klasy bazowej do przypisania instancji webdrivera
        super(driver);
        // inicjalizacja elementów z wykorzystaniem PageFactory
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#top-menu")
    private WebElement topMenu;

    public boolean checkMenuItemExists(String itemText) {
        // . - służy do zaznaczenia aktualnego węzła
        // / - służy do wyszukania od elementu root
        String xpathText = "./li[contains(.,\"" + itemText + "\")]";

        try {
            topMenu.findElement(By.xpath(xpathText));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
