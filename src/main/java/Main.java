import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.println("please enter your user name:");
            String userName = input.next();
            System.out.println("please enter your password:");
            String password = input.next();
            enter(userName, password);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            System.out.println("you entered an incorrect input");
        }
    }

    public static void enter(String userNameInput, String passwordInput) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        //dvir: "webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
        //Elad : "webdriver.chrome.driver","C:\\Users\\User\\chromedriver_win32\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        WebElement personalInfo = driver.findElement(By.className("info-btn")).findElement(By.tagName("a"));
        personalInfo.click();
        String MainWindow = driver.getWindowHandle();

        // To handle all new opened tab.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child tab
                driver.switchTo().window(ChildWindow);
            }
        }
        WebElement userName = driver.findElement(By.id("Ecom_User_ID"));
        if (userName != null)
        {
            userName.sendKeys(userNameInput);
        }
        WebElement password = driver.findElement(By.id("Ecom_Password"));
        if (password != null)
        {
            password.sendKeys(passwordInput);
        }
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.linkText("מערכת Moodle")).click();

        //courses
        Thread.sleep(3000);  //wait for the website to load
        List<WebElement> coursesList = driver.findElements(By.cssSelector("a[class = 'aalink coursename']"));
        for (int i = 0; i < coursesList.size(); i++) {
            String courseName = coursesList.get(i).getText();
            courseName = courseName.replace("שם הקורס", "").trim();

            System.out.println("\t" + (i + 1) + ") " + courseName);
        }
        System.out.println("\n\nplease enter the course you want to enter:(between 1-"+coursesList.size()+")");
        int courseNumber = input.nextInt();
        while (courseNumber<=0 || courseNumber>coursesList.size())
        {
            System.out.println("you entered an invalid course number,please try again");
            courseNumber = input.nextInt();
        }
        coursesList.get(courseNumber - 1).click();
        driver.manage().window().maximize();

        //log out
    Thread.sleep(2000);   //wait to see the opened site
        driver.findElement(By.id("action-menu-toggle-1")).click();
        driver.findElement(By.linkText("התנתקות")).click();
        driver.findElement(By.linkText("יציאה")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}





