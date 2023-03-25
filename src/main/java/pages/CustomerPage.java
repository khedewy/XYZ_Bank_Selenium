package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {
    private WebDriver driver;
    Select select;
    public CustomerPage(WebDriver driver){
        this.driver = driver;
    }
    private By userSelect = By.id("userSelect");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By loginAssertion = By.xpath("//span[@class='fontBig ng-binding']");
    private By transactionBtn = By.xpath("//button[@ng-class='btnClass1']");
    private By depositButton = By.xpath("//button[@ng-class='btnClass2']");
    private By WithdrawlBtn = By.xpath("//button[@ng-class='btnClass3']");

    public void Login(){
        select = new Select(driver.findElement(userSelect));
        select.selectByVisibleText("Harry Potter");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginBtn)));
        driver.findElement(loginBtn).click();
    }

    public String getAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginAssertion)));
        return driver.findElement(loginAssertion).getText();
    }

    public TransactionPage navigateToTransactionPage(){
        driver.findElement(transactionBtn).click();
        return new TransactionPage(driver);
    }

    public DepositPage navigateToDepositPage(){
        driver.findElement(depositButton).click();
        return new DepositPage(driver);
    }

    public WithdrawlPage navigateToWithdrawlPage(){
        driver.findElement(WithdrawlBtn).click();
        return new WithdrawlPage(driver);
    }
}
