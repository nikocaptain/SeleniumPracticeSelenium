package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {
    // https://www.amazon.com/ adresine gidin
    // arama kutusuna Nutella yazip aratın
    // ilk ürüne tıklayın
    // tüm sayfanın fotografını cekin

    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        // arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // tüm sayfanın fotografını cekin

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMdd-HHmmss");//dd buyuk olursa yılın kacıncı günü oldugunu verir.
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;
        //File kaydet=new File("target/ekranGoruntusu/tumSayfa.jpeg");

        //File geciciDosya=ts.getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(geciciDosya,kaydet);

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("target/ekranGoruntusu/tumSayfa" + tarih + ".jpeg"));
    }

    @Test
    public void test02ReusableMethodCozumu() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        // arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // tüm sayfanın fotografını cekin
        tumSafyaEkranResmi();
    }
}
