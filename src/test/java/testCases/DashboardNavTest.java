package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DashboardNavPage;
import pageObjects.DashboardPage;
import pageObjects.UserLogin;
import testBase.BaseClass;

public class DashboardNavTest extends BaseClass {
    UserLogin userLogin;
    DashboardPage dashboardPage;
    DashboardNavPage dashboardNavPage;

    @BeforeClass
    public void setup() {
        dashboardPage = new DashboardPage(driver);
        dashboardNavPage = new DashboardNavPage(driver); // driver is initialized from BaseClass
    }

    @Test(priority = 1)
    public void validLoginFlow() {
        userLogin = new UserLogin(driver);
        userLogin.usernameEntryBox(p.getProperty("Username"));
        userLogin.passwordEntryBox(p.getProperty("Password"));
        userLogin.hitSignIn();
    }

    @Test(priority = 2)
    public void clickOnDashboardButton() {
        dashboardPage.goToDashboardPage(driver);
    }

    @Test(priority = 3)
    public void checkIfUserIsOnDashboardPage() {
        Assert.assertTrue(dashboardPage.userIsOnDashboardPage());
    }

    @Test(priority = 4)
    public void verifyTheCountsBetweenDashboardAndApplicationPage() throws InterruptedException {
        try {
            logger.info("***** Capturing the number displayed under 'Managed Applications' *******");
            int countNumbersFromManageAppDashboard = dashboardNavPage.countNumbersFromManageApplication();
            logger.info("***** Click on the 'Managed Applications' Card ********");
            dashboardNavPage.clickOnDisplayMgAppScr();
            logger.info("****** Count the total number of applications listed *******");
            Assert.assertTrue(dashboardNavPage.userIsOnApplicationPg(), "User is not on application page");
            logger.info("****** Compare Counts 'Assert that countFromDashboard == countFromApplicationPage'.************");
            Assert.assertEquals(countNumbersFromManageAppDashboard, dashboardNavPage.countNumbersFromApplicationPage(driver));
        }catch (Exception e){
            Assert.fail();
            e.printStackTrace();
            logger.info(" countFromDashbord does not matches countFromApplicationPage");
            logger.debug(" Debug logger started....");
        }

        logger.info("********************** Test Finished ***********************");
    }

}
