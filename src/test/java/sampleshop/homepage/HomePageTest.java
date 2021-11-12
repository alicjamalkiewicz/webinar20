package sampleshop.homepage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sampleshop.BaseTest;
import sampleshop.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void checkCategoriesInMenu() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.checkMenuItemExists("Clothes"));
        Assert.assertTrue(homePage.checkMenuItemExists("Produkty powiązane"));
        Assert.assertTrue(homePage.checkMenuItemExists("Art"));

//        Assert.assertFalse(homePage.checkMenuItemExists("Kontakt z nami"));
    }

//    @Test
//    public void fakeTest() {
//        driver.findElement(By.className("fakeClassName"));
//    }
}
