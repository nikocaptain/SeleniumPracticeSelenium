package day_02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_Tekrar extends TestBase {

    // https://www.amazon.com/ adresine gidin
    // arama motorunda nutella yazip aratınız
    // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız

        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella", Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

        List<WebElement> sonuc=driver.findElements(By.xpath("//*[@class='s-image']"));

        for (int i = 0; i <4 ; i++) {
            sonuc=driver.findElements(By.xpath("//*[@class='s-image']"));
            sonuc.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }
    }
}
