package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Login {

    private final WebDriver driver;
    private final By userId = By.name("uid");
    private final By password = By.name("password");
    private final By btnLogin = By.name("btnLogin");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(String user, String pass) {
        driver.findElement(userId).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
    }

    public MngrHome clickLoginBtn() {
        driver.findElement(btnLogin).click();
        try {
            getAlert();
        } catch (NoAlertPresentException e) {
            return new MngrHome(driver);
        }
        return null;
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }
}