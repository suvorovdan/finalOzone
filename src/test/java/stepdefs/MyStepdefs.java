package stepdefs;

import cucumber.api.java.ru.*;
import needfortest.OzonGood;
import steps.Steps;

public class MyStepdefs {
    Steps step = new Steps();
    public static OzonGood smart;
    public static OzonGood photo;
    
    @Дано("^открыт сайт ozone\\.ru$")
    public void открытСайтOzoneRu() throws Throwable {
    }


    @Когда("^я выбираю категорию \"(.*)\"$")
    public void яВыбираюКатегорию(String arg0) throws Throwable {
        step.chooseMenu(arg0);
    }

    @Когда("^выбираю пункт \"(.*)\"$")
    public void выбираюПункт(String arg0) throws Throwable {
        step.chooseCategory(arg0);
    }

    @Когда("^выбираю начальную цену \"(.*)\"$")
    public void выбираюНачальнуюЦену(String arg0) throws Throwable {
        step.chooseStartPrice(arg0);
    }

    @И("^выбираю производителя \"(.*)\"$")
    public void выбираюПроизводителя(String arg0) throws Throwable {
        step.chooseBrandName(arg0);
    }

    @Тогда("^выбираю первый товар, добавляю его в корзину и запоминаю название и цену$")
    public void выбираюПервыйТоварДобавляюЕгоВКорзинуИЗапоминаюНазваниеИЦену() throws Throwable {
        smart = step.chooseAndRememberGood();
    }

    @Когда("^перехожу в корзину$")
    public void перехожуВКорзину() throws Throwable {
        step.cart();
    }

    @Тогда("^проверяю наличие и соответствие добавленого товара$")
    public void проверяюНаличиеИСоответствиеДобавленогоТовара() throws Throwable {
        step.checkGood(smart);
    }

    @Когда("^нажимаю на кнопку Удалить всё$")
    public void нажимаюНаКнопкуУдалитьВсё() throws Throwable {
        step.deleteAll();
    }

    @Тогда("^проверяю, что корзина пуста$")
    public void проверяюЧтоКорзинаПуста() throws Throwable {
        step.checkCartEmptyness();
    }

    @И("^я выбираю подкатегорию \"(.*)\"$")
    public void яВыбираюПодкатегорию(String arg0) throws Throwable {
        step.chooseSubCategory(arg0);
    }

    @И("^выбираю тип \"(.*)\"$")
    public void выбираюТип(String arg0) throws Throwable {
        step.chooseType(arg0);
    }

    @Тогда("^выбираю первый товар, добавляю его в корзину, запоминаю название и цену$")
    public void выбираюПервыйТоварДобавляюЕгоВКорзинуЗапоминаюНазваниеИЦену() throws Throwable {
        photo = step.chooseAndRememberGood2();
    }


    @И("^выбираю производителя  \"(.*)\"$")
    public void выбираюПроизводителя2(String arg0) throws Throwable {
        step.chooseBrandName2(arg0);
    }

    @Тогда("^проверяю наличие в корзине и соответствие добавленого товара$")
    public void проверяюНаличиеВКорзинеИСоответствиеДобавленогоТовара() throws Throwable {
        step.checkGood(photo);
    }
}
