/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author viznney
 */
public class TC01ReservaTest {

    public TC01ReservaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testReserva() {
        System.setProperty("webdriver.chrome.driver", "F:\\NetBeansProjects\\libreria selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("login")).click();
        assertEquals(driver.findElement(By.linkText("SIGN-OFF")).getText(), "SIGN-OFF");
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");

        driver.findElement(By.name("findFlights")).click();
        driver.findElement(By.name("reserveFlights")).click();
        driver.findElement(By.name("passFirst0")).clear();
        driver.findElement(By.name("passFirst0")).sendKeys("Alan");
        driver.findElement(By.name("passLast0")).clear();
        driver.findElement(By.name("passLast0")).sendKeys("Figueroa");
        driver.findElement(By.name("creditnumber")).clear();
        driver.findElement(By.name("creditnumber")).sendKeys("2461357");
        driver.findElement(By.name("buyFlights")).click();
        assertEquals(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText(), "Your itinerary has been booked!");
        driver.findElement(By.linkText("SIGN-OFF")).click();
        driver.close(); 
    }

}
