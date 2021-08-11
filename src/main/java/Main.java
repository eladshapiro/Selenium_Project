import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


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
        personalInfo.click();
        driver.manage().window().maximize();
        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();
       while(i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
            }
        }
        WebElement userName=driver.findElement(By.id("Ecom_User_ID"));
        if (userName!=null)
        {
            userName.sendKeys("dvirkazayof");
        }
        WebElement password= driver.findElement(By.id("Ecom_Password"));
        password.sendKeys("ofrit1204");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.linkText("מערכת Moodle")).click();
        //courses
        System.out.println(driver.findElements(By.className("aalink coursename")).size());




    }
    public static void courses() throws IOException
    {

    }
}