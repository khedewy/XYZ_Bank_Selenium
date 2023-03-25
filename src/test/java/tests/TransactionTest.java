package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.DepositPage;
import pages.HomePage;
import pages.TransactionPage;

public class TransactionTest extends TestBase{
    HomePage home;
    CustomerPage customerPage;
    DepositPage depositPage;
    TransactionPage transactionPage;

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
        depositPage.addDepositAmount("220");
        Assert.assertEquals(depositPage.getAssertionMessage(),"Deposit Successful");
    }
    @Test(priority = 4)
    public void navigateToTransactionsAndAssertTransactions(){
        customerPage = new CustomerPage(driver);
        customerPage.navigateToTransactionPage();
        transactionPage = new TransactionPage(driver);
        Assert.assertEquals(transactionPage.getAssertionMessage(),"220");

    }
}
