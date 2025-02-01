package hooks;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(){
        DriverManager.getDriver();
    }
    @AfterAll
    public void tearDown(){
        DriverManager.quitDriver();

    }
}
