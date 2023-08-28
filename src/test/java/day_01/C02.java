package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");
        Thread.sleep(1000);
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz


        String teknosaTitle = driver.getTitle();
        System.out.println("Teknosa title : " + teknosaTitle);
        String teknosaUrl = driver.getCurrentUrl();
        System.out.println("Teknosa Url : " + teknosaUrl);


        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz

        if (teknosaTitle.contains("Teknoloji")){
            System.out.println("Title Teknoloji iceriyor");
        }else {
            System.out.println("Title Teknoloji icermiyor");
        }


        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz

        if (teknosaUrl.contains("teknosa")){
            System.out.println("url teknosa iceriyor");
        }else {
            System.out.println("url teknosa icermiyor");
        }

        // "https://medunna.com/" adresine gidiniz

        driver.get("https://medunna.com/");
        Thread.sleep(1000);


        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz

        String medunnaTitle= driver.getTitle();
        System.out.println("medunna title : "+medunnaTitle);

        String medunnaUrl =driver.getCurrentUrl();
        System.out.println("medunna url : "+medunnaUrl);


        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.

        if (medunnaTitle.contains("MEDUNNA")){
            System.out.println("Title MEDUNNA iceriyor");
        }else{
            System.out.println("Title MEDUNNA icermiyor");
        }


        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz

        if (medunnaUrl.contains("medunna")){
            System.out.println("Url medunna iceriyor");
        }else {
            System.out.println("Url medunna icermiyor");
        }



        // teknosa adresine geri donunuz

        driver.navigate().back();
        Thread.sleep(1000);

        // Sayfayı yenileyiniz

        driver.navigate().refresh();
        Thread.sleep(1000);

        // medunna adresine ilerleyiniz

        driver.navigate().forward();
        Thread.sleep(1000);

        // Sayfayı yenileyiniz

        driver.navigate().refresh();
        Thread.sleep(1000);

        // pencereyi kapat

        driver.close();


    }
}
