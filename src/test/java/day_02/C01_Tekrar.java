package day_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {



    @Test
    public void test01() {


        // https://www.amazon.com/ adresine gidin

driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       String tagName= aramaKutusu.getTagName();
        Assert.assertEquals("input",tagName);

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String attributeName=aramaKutusu.getAttribute("name");
        System.out.println(attributeName);

        Assert.assertTrue(attributeName.equals("field-keywords"));

    }
}
