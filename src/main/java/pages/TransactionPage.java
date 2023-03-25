package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {
    private WebDriver driver;
    public TransactionPage(WebDriver driver){
        this.driver = driver;
    }
    private By assertionMessage = By.xpath("//td[@class='ng-binding' and text()='220']");

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
