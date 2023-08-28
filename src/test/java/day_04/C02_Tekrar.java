package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    // 1- https://www.amazon.com sayfasina gidelim
// 2- url'in 'amazon' icerdigini test edelim
// 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
// 4- title'in 'Best Buy' icerdigini test edelim
// 5- ilk sayfaya(amazon) donup sayfada java aratalım
// 6- arama sonuc yazısının 'Java' icerdigini test edelim
// 7- ikinci sayfaya(bestbuy) donelim
// 8- logonun gorundugunu test edelim


    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        bekle(2);
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        // 4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        bekle(2);
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);
        // 6- arama sonuc yazısının 'Java' icerdigini test edelim

        WebElement aramaSonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucYazisi.getText().contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        // 8- logonun gorundugunu test edelim

        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
