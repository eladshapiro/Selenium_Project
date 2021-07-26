import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException {
      try {
          enter();
      }
      catch (IOException e)
      {

      }


    }


    public static void enter() throws IOException
    {
        //dvir: "webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
        //Elad : "webdriver.chrome.driver","C:\\Users\\User\\chromedriver_win32\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        WebElement personalInfo=driver.findElement(By.className("info-btn")).findElement(By.tagName("a"));
        System.out.println(personalInfo.getText());
        personalInfo.click();
        driver.manage().window().maximize();
        driver.get(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebElement userName=driver.findElement(By.id("Ecom_User_ID"));
        if (userName!=null)
        {
            userName.sendKeys("dvirkazayof");
        }
        WebElement password= driver.findElement(By.id("Ecom_Password"));
        password.sendKeys("ofrit1204");
        driver.findElement(By.id("wp-submit")).click();
        driver.get(driver.getCurrentUrl());
    }
}