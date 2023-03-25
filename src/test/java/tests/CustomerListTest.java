package tests;

import data.AddCustomerData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.CustomerListPage;
import pages.HomePage;

import java.io.IOException;
import java.time.Duration;

public class CustomerListTest extends TestBase{

    HomePage home;
    BankManagerPage managerPage;
    CustomerListPage customer;
    AddCustomerPage add;

    @Test
    public void navigateToManagerPage(){
        home = new HomePage(driver);
        home.navigateToBankManagerPage();
    }
    @Test(priority = 1)
    public void navigateToAddCustomer(){
        managerPage = new BankManagerPage(driver);
        managerPage.navigateToAddCustomerPage();
    }
    @Test(priority =2)
    public void EnterCustomerData() throws IOException, ParseException {
        AddCustomerData data = new AddCustomerData(driver);
        data.UserData();
        add = new AddCustomerPage(driver);
        add.enterCustomerData(data.firstName, data.lastName, data.postCode);
    }

    @Test(priority = 3)
    public void navigateToCustomerList(){
        managerPage = new BankManagerPage(driver);
        managerPage.navigateToCustomerListPage();
    }

    @Test(priority = 4)
    public void editAccounts(){
        customer = new CustomerListPage(driver);
        customer.searchAboutAccount("Mahmoud");
        Assert.assertEquals(customer.getAssertionMessage(),"Mahmoud");

    }

    @Test(priority = 5)
    public void deleteAccountCreated(){
        customer = new CustomerListPage(driver);
        customer.deleteAccount();
    }
}
