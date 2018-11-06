package pages;

import needfortest.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    Actions actions;


    public BasePage(){
        driver = Init.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
    int timeOut = 15;

    public void click(WebElement element){

        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void waitForVisible(WebElement element){
        new WebDriverWait(driver,timeOut).until(ExpectedConditions.visibilityOf(element));
    }
}
