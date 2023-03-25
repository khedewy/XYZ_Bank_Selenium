package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage {
    private final WebDriver driver;
    public BankManagerPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addCustomerBtn = By.xpath("//button[@ng-class='btnClass1']");
    private final By openAccountBtn = By.xpath("//button[@ng-class='btnClass2']");
    private final By customerBtn = By.xpath("//button[@ng-class='btnClass3']");

    public AddCustomerPage navigateToAddCustomerPage(){
        driver.findElement(addCustomerBtn).click();
        return new AddCustomerPage(driver);
    }

    public OpenAccountPage navigateToOpenAccountPage(){
        driver.findElement(openAccountBtn).click();
        return new OpenAccountPage(driver);
    }
    public CustomerListPage navigateToCustomerListPage(){
        driver.findElement(customerBtn).click();
        return new CustomerListPage(driver);
    }
}
