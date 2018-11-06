package pages;

import needfortest.OzonGood;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzonSearchPage extends BasePage {
    private static final String patternForGoodsSearch = "//a[contains(text(),'%s')]";

    int timeOut = 25;

    @FindBy(className = "item-wrapper")
    WebElement searchResult;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    WebElement cartButton;

    @FindBy(xpath = "//div[@data-test-id = 'filter-block-brand']")
    WebElement brandFilterBlock;

    @FindBy(xpath = "//div[@class = 'input-item']/input[contains(@data-test-id,'from')]")
    WebElement startPrice;

    @FindBy(className = "menu-link")
    WebElement trick;

//div[@data-test-id = 'filter-block-brand'].//span[contains(text(),'Apple')]/../span[@class='checkmark']
    @FindBy(xpath = "//div[contains(@class,'five-dots')]")
    WebElement five;

    public void chooseStartPrice(String price){
        click(startPrice);
        startPrice.clear();
        startPrice.sendKeys(Keys.BACK_SPACE);
        startPrice.sendKeys(Keys.BACK_SPACE);
        startPrice.sendKeys(Keys.BACK_SPACE);
        startPrice.sendKeys(Keys.BACK_SPACE);
        startPrice.sendKeys(price);
        click(startPrice);
        startPrice.sendKeys(Keys.ENTER);
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(five));
    }

    public void chooseBrand(String brandName){
        actions.moveToElement(trick).perform();

        new WebDriverWait(driver,10).until(ExpectedConditions
                .invisibilityOf(five));

        click(driver.findElement(By.xpath("//*[@data-test-id = 'filter-block-brand-show-all']")));
        waitForVisible(brandFilterBlock);
        String name = ".//span[contains(text(),'" + brandName + "')]/../span[@class='checkmark']";
        List<WebElement> temp = brandFilterBlock.findElements(By.xpath(name));
        String mess = "Не найдена категория " + brandName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(five));
    }

    public void chooseBrand2(String brandName){
        actions.moveToElement(trick).perform();

        new WebDriverWait(driver,10).until(ExpectedConditions
                .invisibilityOf(five));

        String name = ".//span[contains(text(),'" + brandName + "')]/../span[@class='checkmark']";
        List<WebElement> temp = brandFilterBlock.findElements(By.xpath(name));
        String mess = "Не найдена категория " + brandName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(five));
    }
//*[@class ='item-view']/.//*[@class ='name']
    public OzonGood chooseFirstGood(){
        List<WebElement> temp = searchResult.findElements(By.className("item-view"));
        Assert.assertTrue(temp.size()!=0);

        OzonGood ozonGood = new OzonGood(temp.get(temp.size()-2).findElement(By.className("name")).getText(),
                temp.get(temp.size()-2).findElement(By.className("price-number")).getText().replace(" ",""));

        actions.moveToElement(trick).perform();
        new WebDriverWait(driver,10).until(ExpectedConditions
                .invisibilityOf(driver.findElement(By.xpath("//*[contains(@class,'five-dots')]"))));

        click(temp.get(temp.size()-2).findElement(By.className("name")));
        return ozonGood;
    }

    public OzonGood chooseFirstGood2(){
        int k = 1;
        List<WebElement> temp = searchResult.findElements(By.className("item-view"));
        Assert.assertTrue(temp.size()!=0);

        OzonGood ozonGood = new OzonGood(temp.get(temp.size()-k).findElement(By.className("name")).getText(),
                temp.get(temp.size()-k).findElement(By.className("price-number")).getText().replace(" ",""));

        actions.moveToElement(trick).perform();
        new WebDriverWait(driver,10).until(ExpectedConditions
                .invisibilityOf(five));

        click(temp.get(temp.size()-k).findElement(By.className("name")));
        return ozonGood;
    }

    public void chooseGood(String nameOfGood){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(patternForGoodsSearch,nameOfGood))));
        driver.findElement(By
                .xpath(String.format(patternForGoodsSearch,nameOfGood))).click();
    }
    public void goToCart(){
        cartButton.click();
    }

    public void chooseType(String subcategoryName){//a[contains(@data-test-category-name,'Зеркальные фотокамеры')]
        String findPattern = "//a[contains(@data-test-category-name,'%s')]";//
        String xp = String.format(findPattern,subcategoryName);
//        actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Страна производства')]"))).perform();
//        waitForVisible(driver.findElement(By.xpath("//div[contains(text(),'Страна производства')]")));

        driver.navigate().refresh();
        List<WebElement> temp = driver.findElements(By.xpath(xp));
        String mess = "Не найдена категория " + subcategoryName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(five));

    }
}
