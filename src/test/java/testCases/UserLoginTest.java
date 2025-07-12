package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.UserLogin;
import testBase.BaseClass;

import java.util.logging.Logger;


public class UserLoginTest extends BaseClass {
    UserLogin userLogin;

    @BeforeClass
    public void setup() {
        userLogin = new UserLogin(driver); // driver is initialized from BaseClass
    }

    @Test(priority = 1)
    public void validLoginFlow() {
        logger.info("************************Test case for valid login flow is starting********************************");
        userLogin.usernameEntryBox(p.getProperty("Username"));
        userLogin.passwordEntryBox(p.getProperty("Password"));
        userLogin.hitSignIn();
    }

}
