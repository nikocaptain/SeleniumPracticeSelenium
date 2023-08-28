package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload extends TestBase {
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

        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        bekle(2);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Benim Dosyam");
        bekle(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.

        //    "C:\Users\Niyazi        \Desktop\deneme.txt"
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\deneme.txt";
        String dosyaYolu=farkliKisim+ortakKisim;

        driver.findElement(By.xpath("//*[@name='upfile']")).sendKeys(dosyaYolu);

        // 'Press' butonuna basın

        driver.findElement(By.xpath("//input[@value='Press']")).click();

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz

        WebElement benimDosyamWE=driver.findElement(By.tagName("blockquote"));

        Assert.assertEquals("Benim Dosyam",benimDosyamWE.getText());

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

        WebElement dosyaIcerigi=driver.findElement(By.tagName("pre"));
        Assert.assertTrue(dosyaIcerigi.getText().contains("Merhaba Dunya"));
    }
}
