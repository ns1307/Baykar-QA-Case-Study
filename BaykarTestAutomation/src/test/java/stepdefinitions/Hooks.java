package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.Helper;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver(); // Initialize the driver
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            Helper.getScreenshot(scenario.getName());
        }
        catch (Exception e) {
            System.out.println("Fail in saving screenshot.");
        }
        Driver.quitDriver();
    }
}