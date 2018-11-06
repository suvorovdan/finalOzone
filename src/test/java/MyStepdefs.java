import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import stepdefs.BaseDefs;

public class MyStepdefs extends BaseDefs {
    @Дано("^открыт сайт ozone\.ru$")
    public void открытСайтOzoneRu() throws Throwable {
        throw new PendingException();
    }
    
}
