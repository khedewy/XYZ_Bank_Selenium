package tests;

import data.AddCustomerData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.HomePage;

import java.io.IOException;

public class AddCustomerTest extends TestBase{

    HomePage home;
    BankManagerPage managerPage;
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
}
