package tests;

import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.HomePage;
import pages.OpenAccountPage;


public class OpenAccountTest extends TestBase {
    HomePage home;
    BankManagerPage managerPage;
    OpenAccountPage open;

    @Test
    public void navigateToManagerPage(){
        home = new HomePage(driver);
        home.navigateToBankManagerPage();
    }
    @Test(priority = 1)
    public void navigateToOpenAccount(){
        managerPage = new BankManagerPage(driver);
        managerPage.navigateToOpenAccountPage();
    }

    @Test(priority = 2)
    public void OpenAccount(){
        open = new OpenAccountPage(driver);
        open.OpenAccount();
    }
}
