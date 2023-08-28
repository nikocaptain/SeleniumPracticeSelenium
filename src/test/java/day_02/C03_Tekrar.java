package day_02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_Tekrar extends TestBase {
    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız


    @Test
    public void test01() {
        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");
        bekle(2);

        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();
        bekle(2);

        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

        List<WebElement> sayfalar=driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for (int i = 0; i < 5 ; i++) {
            sayfalar=driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            sayfalar.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }
}
