package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By bankManagerLogin = By.xpath("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
    private By customerLogin = By.xpath("//button[@class='btn btn-primary btn-lg' and text()='Customer Login']");

    public BankManagerPage navigateToBankManagerPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(bankManagerLogin).click();
        return new BankManagerPage(driver);
    }

    public CustomerPage navigateToCustomerLogin(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(customerLogin).click();
        return new CustomerPage(driver);
    }
}
