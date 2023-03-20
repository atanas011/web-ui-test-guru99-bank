package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private static WebDriver driver;
    private static Login login;

    @BeforeAll
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/index.php");
        login = new Login(driver);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/user-data.csv"}, numLinesToSkip = 1)
    public void verifyLogin(String username, String password) {
        login.submit(username, password);
        try {
            var alertText = login.getAlertText();
            assertEquals("User or Password is not valid", alertText);
            assertTrue(driver.getTitle().contains("Home Page"));
        } catch (NoAlertPresentException e) {
            assertTrue(driver.getTitle().contains("Manager HomePage"));
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}