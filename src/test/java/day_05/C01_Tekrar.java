package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {

    // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
    // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
    // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
    // 'Press' butonuna basın
    // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
    // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.

        //"C:\Users\Niyazi\Desktop\Deneme.txt"

        String dosyaYolu="C:\\Users\\Niyazi\\Desktop\\Deneme.txt";
        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Benim Dosyam");
        bekle(2);
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.

        driver.findElement(By.xpath("//input[@name='upfile']")).sendKeys(dosyaYolu);
        bekle(2);

        // 'Press' butonuna basın

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz

        WebElement dosyaNotu=driver.findElement(By.xpath("//blockquote"));
        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

        WebElement dosyaIcerigi=driver.findElement(By.xpath("//pre"));
        Assert.assertTrue(dosyaIcerigi.getText().contains("Merhaba Dunya"));
    }
}
