package day_04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files {
    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        //"C:\Users\Niyazi\Desktop\text.txt"

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Niyazi\\Desktop\\text.txt")));


        //"C:\Users\Niyazi             \Desktop\text.txt"

        String farkliKisim=System.getProperty("user.home");

        String ortakKisim="\\Desktop\\text.txt";

        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
