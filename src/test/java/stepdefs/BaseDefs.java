package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import needfortest.Init;


/**
 * Created by student on 05.11.2018.
 */
public class BaseDefs {
    @Before
    public void start(){
        Init.startUp();
    }

    @After
    public void end(){
        Init.tearDown();
    }
}
