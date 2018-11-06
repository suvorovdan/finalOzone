import needfortest.Init;
import needfortest.OzonGood;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class OzoneFirstTest {
    public static OzonGood smart;
    public static OzonGood photo;

    @Before
    public void start(){
        Init.startUp();
    }

    @After
    public void end(){
        Init.tearDown();
    }

    @Test
    public void firstTest(){
        Steps step = new Steps();
        step.chooseMenu("Электроника");
        step.chooseCategory("Телефоны");
        step.chooseStartPrice("50000");
        step.chooseBrandName("Apple");
        smart = step.chooseAndRememberGood();
        step.cart();
        step.checkGood(smart);
        step.deleteAll();
        step.checkCartEmptyness();
    }

    @Test
    public void secondTest(){
        Steps step = new Steps();
        step.chooseMenu("Электроника");
        step.chooseCategory("Фото- и видеокамеры");
        step.chooseSubCategory("Фотокамеры");

        step.chooseStartPrice("80000");
        step.chooseType("Зеркальные фотокамеры");

        step.chooseBrandName2("Nikon");
        step.chooseBrandName2("Canon");

        photo = step.chooseAndRememberGood2();
        step.cart();
        step.checkGood(photo);
        step.deleteAll();
        step.checkCartEmptyness();
    }
}
