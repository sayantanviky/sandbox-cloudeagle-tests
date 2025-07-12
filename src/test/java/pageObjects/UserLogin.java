package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.GenericUtils;

public class UserLogin extends BasePage {
    //GenericUtils utils;
    public UserLogin(WebDriver driver) {
        super(driver);
        //utils = new GenericUtils();
    }

    private By usernameBox = By.xpath("//input[@name='emailField']");
    private By passwordBox = By.xpath("//input[@name='passField']");
    private By signInButton = By.xpath("//h5[normalize-space()='Sign in']");

    public void usernameEntryBox(String username) {
        WebElement usernameField = GenericUtils.waitForVisibilityOfElementLocated(driver, usernameBox, 1000);
        usernameField.sendKeys(username);
    }

    public void passwordEntryBox(String password) {
        WebElement passwordField = GenericUtils.waitForVisibilityOfElementLocated(driver, passwordBox, 1000);
        passwordField.sendKeys(password);
    }

    public void hitSignIn() {
        driver.findElement(signInButton).click();
    }

}
