package sampleshop.product_details;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sampleshop.BaseTest;
import sampleshop.pages.ProductDetailsPage;

public class ProductDetailsTest extends BaseTest {
    private ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void openPage() {
        driver.get("http://sampleshop.inqa.pl/men/1-1-hummingbird-printed-t-shirt.html#/1-rozmiar-s/8-kolor-bialy");
    }

    @Test(description = "Zamawianie produktu - dodanie do koszyka")
    public void orderElement() {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.selectSize("M");
        productDetailsPage.selectColor("czarny");
        productDetailsPage.addQuantity();
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.modalViewAppears();

        Assert.assertEquals(productDetailsPage.productAddedMessage.getText(), "Produkt dodany poprawnie do Twojego koszyka");

    }



//    @Test
//    public void thisMethodWillFail() {
//        Assert.assertEquals(1, 2);
//    }
}

