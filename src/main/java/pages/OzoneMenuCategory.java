package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzoneMenuCategory extends BasePage{
    @FindBy(xpath = "//span[contains(@class,'category-link')]")
    WebElement showAll;

    public void chooseCategory(String categoryName){
        String findPattern = "//a[contains(text(),'%s')]";
        String xp = String.format(findPattern,categoryName);
        List<WebElement> temp = driver.findElements(By.xpath(xp));
        String mess = "Не найдена категория " + categoryName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));

    }
    @FindBy(xpath = "//div[contains(@class,'five-dots')]")
    WebElement five;

    public void chooseSubCategory(String subcategoryName){
        click(showAll);

        String findPattern = "//a[contains(text(),'%s')]";
        String xp = String.format(findPattern,subcategoryName);
        List<WebElement> temp = driver.findElements(By.xpath(xp));
        String mess = "Не найдена категория " + subcategoryName;
        Assert.assertTrue(mess,temp.size()!= 0);
        click(temp.get(0));
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(five));

    }
}
