package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerListPage {
    private WebDriver driver;
    public CustomerListPage(WebDriver driver){
        this.driver = driver;
    }

    private By searchBox = By.xpath("//input[@placeholder='Search Customer']");
    private By deleteAccount = By.xpath("//button[@ng-click='deleteCust(cust)']");
    private By assertionMessage = By.xpath("//td[@class='ng-binding' and text()='Mahmoud']");

    public void searchAboutAccount(String account){
        driver.findElement(searchBox).sendKeys(account);
    }

    public void deleteAccount(){
        driver.findElement(deleteAccount).click();
    }

    public String getAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
