package day_06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {

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
    public void test01() {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        // arama cubuguna oppo yazip enter'a basınız
        WebElement cookies=driver.findElement(By.xpath("//div[@id='button-1580496494']"));
        try {
            cookies.click();
        } catch (Exception e) {
            System.out.println("cookies yok");
        }



        driver.findElement(By.xpath("//*[@class='sbx-input']")).sendKeys("oppo", Keys.ENTER);
        // sonuc yazısını yazdiriniz

        // ilk urunun fotografını cekin
        // cikan ilk urune tiklayiniz
        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
        // sepete ekleyiniz
        // sepetim'e git tiklayiniz
        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        // Alisverisi tamamlayiniz
        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
    }
}
