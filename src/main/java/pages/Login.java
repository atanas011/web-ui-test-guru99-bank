package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private final WebDriver driver;
    private final By userId = By.name("uid");
    private final By password = By.name("password");
    private final By btnLogin = By.name("btnLogin");
    private final By btnReset = By.name("btnReset");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void submit(String user, String pass) {
        driver.findElement(userId).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        clickLoginBtn();
    }

    private void clickLoginBtn() {
        driver.findElement(btnLogin).click();
    }

    private void clickResetBtn() {
        driver.findElement(btnReset).click();
    }

    public String getAlertText() {
        var alert = driver.switchTo().alert();
        var alertTxt = alert.getText();
        alert.accept();
        return alertTxt;
    }
}