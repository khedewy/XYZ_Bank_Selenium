package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomerPage {
    private final WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstNameTxt = By.xpath("//input[@ng-model='fName']");
    private final By lastNameTxt = By.xpath("//input[@ng-model='lName']");
    private final By postCodeTxt = By.xpath("//input[@ng-model='postCd']");
    private final By submitButton = By.xpath("//button[@type='submit']");

    public void enterCustomerData(String firstName, String lastName, String postCode){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(postCodeTxt).sendKeys(postCode);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButton)));
        driver.findElement(submitButton).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
