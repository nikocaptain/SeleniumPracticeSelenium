package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Tekrar extends TestBase {
    // https://www.amazon.com/ adresine gidin
    // arama kutusuna Nutella yazip aratın
    // ilk ürüne tıklayın
    // tüm sayfanın fotografını cekin


    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın

        driver.findElement(By.xpath("(//h2)[1]")).click();
        bekle(2);

        // tüm sayfanın fotografını cekin

        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/utilities/resim/ekranResmi"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
