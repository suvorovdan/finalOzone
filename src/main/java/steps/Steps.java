package steps;

import io.qameta.allure.Step;
import needfortest.Init;
import needfortest.OzonGood;
import pages.*;

public class Steps extends Init {
    OzonMainPage ozonMainPage = new OzonMainPage();
    OzoneMenuCategory ozoneMenuCategory = new OzoneMenuCategory();
    OzonSearchPage ozonSearchPage = new OzonSearchPage();
    OzonGoodPage ozonGoodPage = new OzonGoodPage();
    OzonCartPage ozonCartPage = new OzonCartPage();

    @Step("Выбрать пункт меню {0}")
    public void chooseMenu(String menu){
        ozonMainPage.chooseMenuCategory(menu);
    }
    @Step("Выбрать категорию меню {0}")
    public void chooseCategory(String category){
        ozoneMenuCategory.chooseCategory(category);
    }
    @Step("Выбрать бренд {0}")
    public void chooseBrandName(String brand){
        ozonSearchPage.chooseBrand(brand);
    }
    @Step("Выбрать бренд {0}")
    public void chooseBrandName2(String brand){
        ozonSearchPage.chooseBrand2(brand);
    }
    @Step("Выбрать начальную цену равную {0}")
    public void chooseStartPrice(String price){
        ozonSearchPage.chooseStartPrice(price);
    }
    @Step("Выбор первого товара из списка и добавление его в корзину")
    public OzonGood chooseAndRememberGood(){
        OzonGood ozonGood = ozonSearchPage.chooseFirstGood();
        ozonGoodPage.addGoodToCart();
        return ozonGood;

    }
    @Step("Выбор первого товара из списка и добавление его в корзину")
    public OzonGood chooseAndRememberGood2(){
        OzonGood ozonGood = ozonSearchPage.chooseFirstGood2();
        ozonGoodPage.addGoodToCart();
        return ozonGood;

    }
    @Step("Переход в корзину")
    public void cart(){
        ozonSearchPage.goToCart();
    }
    @Step("Проверка на соответстие добавленного товара и того что в корзине")
    public void checkGood(OzonGood ozonGood){
        ozonCartPage.checkAddedGood(ozonGood.getGoodName());

    }
    @Step("Нажатие кнопки удалить всё")
    public void deleteAll(){
        ozonCartPage.deleteAllGoods();
    }
    @Step("Проверка пустая ли корзина")
    public void checkCartEmptyness(){
        ozonCartPage.checkEmptyness();
    }
    @Step("Выбор подкатегории {0}")
    public void chooseSubCategory(String subCategory){
        ozoneMenuCategory.chooseSubCategory(subCategory);
    }
    @Step("Выбор типа товара {0}")
    public void chooseType(String type){
        ozonSearchPage.chooseType(type);
    }

}
