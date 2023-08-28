package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {
   protected WebDriver driver;

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
        //driver.quit();
    }

    public void bekle(int x){
        try {
            Thread.sleep(x*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ddmVisibleText(WebElement ddm, String secenek){

        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }


    public void ddmIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);

    }

    public void ddmValue(WebElement ddm,String value){
        Select select=new Select(ddm);
        select.selectByValue(value);
    }

    //UploadFile Robot Class
    public void robotuploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void tumSafyaEkranResmi(){
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");//dd buyuk olursa yılın kacıncı günü oldugunu verir.
        String tarih= date.format(dtf);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File kaydet=new File("target/ekranGoruntusu/tumSayfa"+tarih+".jpeg");

        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kaydet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    }



