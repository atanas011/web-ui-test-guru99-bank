package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MngrHome {

    private final WebDriver driver;
    private final By welcomeTxt = By.cssSelector("tr.heading3 > td");

    public MngrHome(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeTxt).getText();
    }
}