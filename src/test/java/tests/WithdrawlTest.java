package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.DepositPage;
import pages.HomePage;
import pages.WithdrawlPage;
import tests.TestBase;

public class WithdrawlTest extends TestBase {
    HomePage home;
    CustomerPage customerPage;
    WithdrawlPage withdrawlPage;
    DepositPage depositPage;

    @Test
    public void navigateToLogin(){
        home = new HomePage(driver);
        home.navigateToCustomerLogin();
    }

    @Test(priority = 1)
    public void loginAsCustomer(){
        customerPage = new CustomerPage(driver);
        customerPage.Login();
        Assert.assertEquals(customerPage.getAssertionMessage(),"Harry Potter");
    }
    @Test(priority = 2)
    public void navigateToDeposit(){
        customerPage = new CustomerPage(driver);
        customerPage.navigateToDepositPage();
    }
    @Test(priority = 3)
    public void addDepositAmount(){
        depositPage = new DepositPage(driver);
        depositPage.addDepositAmount("120");
        Assert.assertEquals(depositPage.getAssertionMessage(),"Deposit Successful");
    }


    @Test(priority = 4)
    public void navigateToWithdrawl(){
        customerPage = new CustomerPage(driver);
        customerPage.navigateToWithdrawlPage();
    }

    @Test(priority = 5)
    public void MakeWithdrwal() throws InterruptedException {
        withdrawlPage = new WithdrawlPage(driver);
        withdrawlPage.makeWithdrawl("100");
        Assert.assertEquals(withdrawlPage.getAssertionMessage(),"Transaction successful");
    }
}
