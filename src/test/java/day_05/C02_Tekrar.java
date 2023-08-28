package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    // https://www.ilovepdf.com/compress_pdf adrese gidelim
    // Dosya sec butonuna tıklayalım
    // Dosya yuklemek icin robot class'ını kullanalım


    @Test
    public void test01() {
        // https://www.ilovepdf.com/compress_pdf adrese gidelim
        driver.get("https://www.ilovepdf.com/compress_pdf");
        // Dosya sec butonuna tıklayalım

        driver.findElement(By.xpath("//a[@id='pickfiles']")).click();

        // Dosya yuklemek icin robot class'ını kullanalım

        //"C:\Users\Niyazi\Desktop\PDF.pdf"

        String dosyaYolu="C:\\Users\\Niyazi\\Desktop\\PDF.pdf";

        robotuploadFilePath(dosyaYolu);

    }
}
