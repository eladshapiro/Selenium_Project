import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        try {
            enter();
        } catch (IOException e) {
        }


    }


    public static void enter() throws IOException {
        //dvir: "webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
        //Elad : "webdriver.chrome.driver","C:\\Users\\User\\chromedriver_win32\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        WebElement personalInfo = driver.findElement(By.className("info-btn")).findElement(By.tagName("a"));
        personalInfo.click();
        driver.manage().window().maximize();
        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
            }
        }
        WebElement userName = driver.findElement(By.id("Ecom_User_ID"));
        if (userName != null) {
            userName.sendKeys("dvirkazayof");
        }
        WebElement password = driver.findElement(By.id("Ecom_Password"));
        password.sendKeys("ofrit1204");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.linkText("מערכת Moodle")).click();
        WebElement container = driver.findElement(By.id("region-main"));
            List<WebElement> menuShow = container.findElements(By.className("d-sm-inline-block"));
            menuShow.get(2).click();
            List<WebElement> styleOptions =container.findElements(By.tagName("a"));
            styleOptions.get(12).click();
        /*//COURSES_ELEMENTS*/
            WebElement cursesButton = driver.findElement(By.id("page-container-2"));
            List<WebElement> coursesList = cursesButton.findElements(By.tagName("h6"));
        System.out.println(coursesList.size());

        //courses


    }

//        Scanner scanner = new Scanner(System.in);
//        Scanner in = new Scanner (System.in);
//        System.out.println("enter your userName :");
//        String username = scanner.next();
//        System.out.println("enter your password\n> :");
//        String password = scanner.next();
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.aac.ac.il/");
//        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
//
//        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
//        WebElement personalInfo = menuItems.get(20);
//
//        personalInfo.click();
//        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
//        WebElement userPasswordInput = driver.findElement(By.id("Ecom_Password"));
//        userNameInput.sendKeys(username); // <-- real username
//        userPasswordInput.sendKeys(password); // <- password
//        WebElement enter = driver.findElement(By.id("wp-submit"));
//        try {
//            Thread.sleep(500);
//            enter.click();
//            List<WebElement> personalInfo_Options = driver.findElements(By.className("row"));
//            WebElement modelRow = personalInfo_Options.get(5);
//            WebElement modelButton = modelRow.findElement(By.tagName("a"));
//            Thread.sleep(500);
//            modelButton.click();
//            //fix
//            WebElement container = driver.findElement(By.id("region-main"));
//            List<WebElement> menuShow = container.findElements(By.className("d-sm-inline-block"));
//            Thread.sleep(500);
//            menuShow.get(2).click();
//            Thread.sleep(500);
//            List<WebElement> styleOptions =container.findElements(By.tagName("a"));
//            styleOptions.get(12).click();
//            /*//COURSES_ELEMENTS*/
//            WebElement cursesButton = driver.findElement(By.id("page-container-2"));
//            List<WebElement> coursesList = cursesButton.findElements(By.tagName("h6"));
//
////              *********************
//            System.out.println("The amount of the courses are: " + coursesList.size() +"\nList of the courses: ");
//            for (int i = 0; i < coursesList.size(); i++) {
//                System.out.println("--------------------------------------------------------------------------------------");
//                System.out.println("\n" + i);
//                System.out.println(coursesList.get(i).getText());
//            }
//
//            System.out.println("Which course do you want to enter? (between 0-22");
//            int userChoice = in.nextInt();
//            while (userChoice<0 || userChoice >22){
//                System.out.println("Your choice is not exist, please try again");
//                userChoice = in.nextInt();
//            }
//            WebElement userCourse = coursesList.get(userChoice);
//            userCourse.click();
//
//            Thread.sleep(500);
//            WebElement menuButton = driver.findElement(By.id("action-menu-1-menu"));
//            List <WebElement> menuLoggingOf =menuButton.findElements(By.tagName("a"));
//
//
//
//        } catch (Exception e) {
//            System.out.println("Exception...!!");
//        }
//
//    }
}
