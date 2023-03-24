package tests;

import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.Login;
import util.Util;

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
    @MethodSource("userData")
    public void mngrIdShown(String username, String password) throws IOException {
        login.enterCredentials(username, password);
        var mngrHome = login.clickLoginBtn();
        try {
            var alert = login.getAlert();
            assertEquals("User or Password is not valid", alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            assertTrue(mngrHome.getWelcomeText().contains(username));
            Util.takeScreenshot(driver, "mngr-home");
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    // Data Provider
    private static Object[][] userData() {
        String validUser = "mngr486178", validPass = "ebanuze";
        return new Object[][]{
                {"invalid", "invalid"},
                {"invalid", validPass},
                {validUser, "invalid"},
                {validUser, validPass}
        };
    }
}