package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawlPage {
    private WebDriver driver;
    public WithdrawlPage(WebDriver driver){
        this.driver = driver;
    }
    private By wihdrawlBox =By.xpath("//input[@placeholder='amount']");
    private By WiwthdrwalBtn = By.xpath("//button[@class='btn btn-default']");
    private By assertionMessage = By.xpath("//span[text()='Transaction successful']");

    public void makeWithdrawl(String amount) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(wihdrawlBox).sendKeys(amount);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(WiwthdrwalBtn)));
        driver.findElement(WiwthdrwalBtn).click();
    }

    public String getAssertionMessage(){
        return  driver.findElement(assertionMessage).getText();
    }
}
