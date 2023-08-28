package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(2);
        String farkliYoll=System.getProperty("user.home");

        String ortakKisimm="\\Downloads\\some-file.txt";

        String dosyaYolum=farkliYoll+ortakKisimm;

        try {
            Files.delete(Paths.get(dosyaYolum));
        } catch (IOException e) {
            System.err.println("dosya bulunamadı");
        }
        // some-file.txt dosyasini indirelim

        driver.findElement(By.xpath("//*[.='some-file.txt']")).click();
        bekle(3);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //"C:\Users\Niyazi    \Downloads\some-file.txt"

        String farkliYol=System.getProperty("user.home");

        String ortakKisim="\\Downloads\\some-file.txt";

        String dosyaYolu=farkliYol+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
