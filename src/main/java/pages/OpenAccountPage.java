package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {
    private WebDriver driver;
    Select select;
    Alert alert;
    public OpenAccountPage(WebDriver driver){
        this.driver = driver;
    }

    private By userSelect = By.id("userSelect");
    private By currencySelect = By.id("currency");
    private By processBtn = By.xpath("//button[@type='submit']");

    public void OpenAccount(){
        select = new Select(driver.findElement(userSelect));
        select.selectByIndex(2);

        select = new Select(driver.findElement(currencySelect));
        select.selectByIndex(1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(processBtn)));
        driver.findElement(processBtn).click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
    }
}
