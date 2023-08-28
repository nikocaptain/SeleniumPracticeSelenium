package day_02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin


    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");


        // sayfa baslıgının "Google" kelimesini icerdigini test edin

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Google";
        bekle(2);

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // arama cubuguna "Nutella" yazıp aratın

        WebElement aramaKutusu= driver.findElement(By.cssSelector("[id='APjFqb']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // bulunan sonuc sayısını yazdırın

        WebElement sonusSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonusSayisi.getText());
        String actualsonuc=sonusSayisi.getText();

        //sonuc sayısının 100000000  fazla oldugunu test edin

        String [] arr=actualsonuc.split(" ");
       String sonuc= arr[1].replaceAll("\\D","");
       int sonucInt = Integer.parseInt(sonuc);

       Assert.assertTrue(sonucInt>100000000);


    }
}
