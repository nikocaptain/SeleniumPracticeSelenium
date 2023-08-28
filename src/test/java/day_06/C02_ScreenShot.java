package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz


    @Test
    public void test01() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");


        try {
            WebElement cookies=driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']"));
            cookies.click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı yoluna devam et");
        }


        // arama cubuguna oppo yazip enter'a basınız

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='search-input']"));
        aramaKutusu.sendKeys("oppo", Keys.ENTER);




        // sonuc yazısını yazdiriniz

        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("sonuc Yazisi = "+ sonucYazisi.getText());
        bekle(2);

        // ilk urunun fotografını cekin

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMdd-HHmmss");//dd buyuk olursa yılın kacıncı günü oldugunu verir.
        String tarih= date.format(dtf);

        WebElement ilkUrun=driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));
        File kayit=new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".jpeg");
        File gecici=ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,kayit);

        bekle(3);

        // cikan ilk urune tiklayiniz

        ilkUrun.click();
        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // sepete ekleyiniz

        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        bekle(2);

        // sepetim'e git tilayiniz

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        bekle(2);

        // "Siparis Ozeti" webelementinin text'ini yazdiriniz

       WebElement siparisOzeti= driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println(siparisOzeti.getText());
        bekle(2);
        // Alisverisi tamamlayiniz

        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        bekle(2);
        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz

        WebElement teknosaWE=driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(teknosaWE.getText());

    }
}
