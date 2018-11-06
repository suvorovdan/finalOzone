package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzonMainPage extends BasePage{
    private static final String patternForMenuAfterExit = "//span[contains(text(),'%s')]";
    int timeOut = 20;

    @FindBy(xpath = "//a[contains(text(),'Электроника') and contains(@href,'tech')]")
    WebElement menuTech;

//    @FindBy(className = "bHeaderCategoryLinks ")
//    WebElement allMenuSection;

    @FindBy(className = "bHeaderCatalogButton")
    WebElement allMenuSection;



    @FindBy(xpath = "//input[@class='search-input']")
    WebElement areaOfSearch;


    public void chooseMenuCategory(String categoryName){
        String xpathPattern = ".//span[contains(text(),'%s')]";
        String xp = String.format(xpathPattern,categoryName);
        click(allMenuSection);
        List<WebElement> temp = allMenuSection.findElements(By.xpath(xp));
        String mess = "Не найдена секция меню  " + categoryName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));
    }





    public void find(String whatNeedToFined){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(areaOfSearch));
        areaOfSearch.click();
        areaOfSearch.sendKeys(whatNeedToFined);
        areaOfSearch.sendKeys(Keys.ENTER);
    }


}
