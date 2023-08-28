package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownOptions extends TestBase {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin

        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

       List<WebElement> optionlarList= select.getOptions();
        Assert.assertEquals(28, optionlarList.size());

        // dropdown'daki optionların tamamını yazdırın

        int sayac=1;
        for (WebElement w:optionlarList) {
            System.out.println(sayac+". option : "+w.getText());
            sayac++;
        }
        //optionlarList.forEach(t-> System.out.println(t.getText()));//lambda çözümü
    }
}
