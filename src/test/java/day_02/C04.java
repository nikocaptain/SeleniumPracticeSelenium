package day_02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin


    @Test
    public void test01() {

        // https://www.bestbuy.com/ sayfasına gidin

        driver.get("https://www.bestbuy.com/");

        // sayfa Title'ini alın "Best" içerdigini test edin

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Best"));

        // BestBuy logosunun görüntülendigini test edin

        WebElement logobestbuy=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logobestbuy.isDisplayed());

        // Canada logosunun görüntülendigini test edin

        WebElement logoCanada=driver.findElement(By.xpath("(//*[@alt='Canada'])[1]"));
        Assert.assertTrue(logoCanada.isDisplayed());


    }
}
