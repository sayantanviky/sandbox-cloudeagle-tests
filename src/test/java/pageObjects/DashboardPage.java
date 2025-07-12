package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GenericUtils;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By dashboardPgHeader = By.xpath("//h2[normalize-space()='Dashboard']");

    private By specificAlertCategory = By.xpath("//p[contains(text(),'Applications below 70% Usage')]");
    private By clickYesIgnoreOnAlertItem = By.xpath("//div[@class='ant-modal-content']/div[@class='ant-modal-footer']//button[normalize-space()='Yes']");


    public static void goToDashboardPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Step 1: Hover on the sidebar to expand it
        WebElement sidebar = driver.findElement(By.id("innerSideNav"));
        actions.moveToElement(sidebar).perform();

        // Step 2: Wait for the Dashboard option to be visible and clickable
        By dashboardOption = By.xpath("//label[text()='Dashboard']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardOption));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardOption));

        // Step 3: Click the Dashboard button
        driver.findElement(dashboardOption).click();
    }

    public boolean userIsOnDashboardPage() {
        return GenericUtils.waitForElementVisible(driver, dashboardPgHeader, 3000);
    }


    public void scrollToSpecificAlertCategory() {
        driver.findElement(specificAlertCategory).click();
    }

    public void clickIgnoreOnActionItem(WebDriver driver) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Hover over the 3-dot menu (More icon)
        By moreIcon = By.cssSelector("div.ant-dropdown-trigger.styles_moreIconWrapper__YFgY6");
        WebElement iconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moreIcon));
        actions.moveToElement(iconElement).perform();

        // Step 2: Wait for the "Ignore" button to be visible
        By ignoreBtn = By.xpath("//button[normalize-space()='Ignore']");
        WebElement ignoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ignoreBtn));

        // Step 3: Click on the "Ignore" button
        ignoreElement.click();
    }

    public void confirmIgnoreOnActionItem() {
        GenericUtils.waitForElementVisible(driver, clickYesIgnoreOnAlertItem, 3);
        driver.findElement(clickYesIgnoreOnAlertItem).click();
    }


}
