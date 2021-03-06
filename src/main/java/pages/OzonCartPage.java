package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzonCartPage extends BasePage {
    private static final String patternForMenuWhenEntered = "//span[contains(text(),'%s')]";
    int timeOut = 25;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    WebElement cartButton;

    @FindBy(xpath = "//div[contains(text(),'Удалить')]")
    WebElement deleteAllFromCartButton;

    public void checkAddedGood(String good){
        try{
            driver.findElement(By.xpath(String.format(patternForMenuWhenEntered,good))).getText();
        }catch (org.openqa.selenium.NoSuchElementException e){
            String mes = "Данный товар не был добавлен: " + good;
            Assert.assertTrue(mes,false);

        }
    }
    public void deleteAllGoods(){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[contains(text(),'Доставим')]")));
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(deleteAllFromCartButton));
        deleteAllFromCartButton.click();
    }
    public void checkEmptyness(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'modal-container']")));
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[contains(text(),'Корзина')]")));
        cartButton.click();

        try{
            WebElement emptyCart = driver
                    .findElement(By.xpath(String.format(patternForMenuWhenEntered,"пуста")));
            new WebDriverWait(driver,timeOut)
                    .until(ExpectedConditions
                            .elementToBeClickable(emptyCart));
        }catch (org.openqa.selenium.NoSuchElementException e){
            Assert.assertNotEquals(" корзина не пуста ","","");
//            System.err.println(" корзина не пуста ");
        }
    }

}
