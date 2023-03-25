package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositPage {
    private WebDriver driver;
    public DepositPage(WebDriver driver){
        this.driver = driver;
    }

    private By depositBox = By.xpath("//input[@type='number']");
    private By depositBtn = By.xpath("//button[@type='submit']");
    private By assertionMessage = By.xpath("//span[@class='error ng-binding']");

    public void addDepositAmount(String amount){
        driver.findElement(depositBox).sendKeys(amount);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(depositBtn)));
        driver.findElement(depositBtn).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
