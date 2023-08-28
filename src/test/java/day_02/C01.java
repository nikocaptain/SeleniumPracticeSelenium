package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz

        WebElement aramakutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       String actual= aramakutusu.getTagName();
       String expected="input";
        //Assert.assertEquals(expected,actual);
        Assert.assertTrue(expected.equals(actual));

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String actualNameDegeri=aramakutusu.getAttribute("name");
        String expectedNameDegeri="field-keywords";
        Assert.assertEquals(expectedNameDegeri,actualNameDegeri);
        //Assert.assertTrue(expectedNameDegeri.equals(actualNameDegeri));



    }
}
