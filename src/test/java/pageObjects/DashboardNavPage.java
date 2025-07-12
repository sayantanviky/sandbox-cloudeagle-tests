package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.GenericUtils;


public class DashboardNavPage extends BasePage {
    public DashboardNavPage(WebDriver driver) {
        super(driver);
    }

    private By noDispMgAppScreen = By.xpath("//div[@class='styles_cardDetailWrapper__C6Pn0 styles_manageApplications__YnzxX']/div/p[contains(text(),'Managed Applications')]/ancestor::div[1]/parent::div/h1");
    private By applicationPg = By.xpath("//div[@class='applicationView_menuHeading__-XkME']/p[contains(text(),'Applications')]");
    private By firstRowOfTableRow = By.xpath("(//div[@class='styles_appNameCellWrapper__jqRp0'])[1]");
    private By paginationPgNo = By.xpath("//div[@class='styles_pageOptionWrapper__1oRxq']/p[contains(text(),'')][2]");


    public int countNumbersFromManageApplication() {
        GenericUtils.waitForElementVisible(driver, noDispMgAppScreen, 5);
        String count = driver.findElement(noDispMgAppScreen).getText();
        int countInt = Integer.parseInt(count);
        return countInt;
    }
    public void clickOnDisplayMgAppScr() {
        driver.findElement(noDispMgAppScreen).click();
    }
    public boolean userIsOnApplicationPg() {
        return GenericUtils.waitForElementVisible(driver, applicationPg, 5);
    }
    public int countNumbersFromApplicationPage(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Focus on the first row
        WebElement firstRow = driver.findElement(firstRowOfTableRow);
        actions.moveToElement(firstRow).click().perform();

        int count = 1;
        int maxTries = 300; // safety limit to avoid infinite loops
        int stableCount = 0;

        while (stableCount < 10 && count < maxTries) {
            // Press down arrow to move to the next row
            actions.sendKeys(Keys.ARROW_DOWN).perform();

            Thread.sleep(500); // wait for lazy load to populate

            String pageNumber = driver.findElement(paginationPgNo).getText();
            int number = Integer.parseInt(pageNumber.replace("of ", "").trim());

            if (number > count) {
                count = number;
                stableCount = 0; // reset since new item was loaded
            } else {
                stableCount++; // no new row loaded
            }
        }

        return count;
    }
}
