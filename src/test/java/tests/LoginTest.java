package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.Login;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/index.php");
    }

    @Test
    public void verifyLogin() {
        new Login(driver).submit("mngr486178", "ebanuze");
        assertTrue(driver.getTitle().contains("Manager HomePage"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}