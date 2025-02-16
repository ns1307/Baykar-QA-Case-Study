package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.components.NavbarComponent;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Helper;

import java.util.List;


public class NavbarStep {
    private NavbarComponent navbar;

    public NavbarStep() {
        navbar = new NavbarComponent();
    }


    @Given("User is on the Baykartech homepage")
    public void user_is_on_homepage() {
        String url = ConfigReader.getProperty("BaykarKariyerHomepage." + ConfigReader.getProperty("default.language")).trim();
        Driver.openURL(url);
    }

    @When("User clicks on each navbar element")
    public void user_clicks_navbar_elements() {
        List<WebElement> navItems = navbar.navBarElements;
        for (WebElement navItem : navItems) {
            if (!navItem.getText().isEmpty() && !navItem.getText().replace(" ", "").equals("")) {
                if (navItem.findElements(By.cssSelector(".dropdown-toggle")).size() > 0) {
                    WebElement dropdownToggle = navItem.findElement(By.cssSelector(".dropdown-toggle"));
                    List<WebElement> dropdownItems = navItem.findElements(By.cssSelector(".dropdown-menu .dropdown-item"));
                    for (WebElement dropdownItem : dropdownItems) {
                        dropdownToggle.click();
                        Helper.wait(1);
                        String href = dropdownItem.getAttribute("href");
                        dropdownItem.click();
                        Helper.wait(1);
                        //Href link and opened link should be matched, so that we can say that the button works fine.
                        Assert.assertTrue(Driver.getCurrentURL().contains(href));
                        Driver.navigateBack();
                    }
                } else {
                    String href = navItem.findElement(By.className("nav-link")).getAttribute("href");
                    navItem.click();
                    Helper.wait(2);
                    //Href link and opened link should be matched, so that we can say that the button works fine.
                    Assert.assertTrue(Driver.getCurrentURL().contains(href));
                    Driver.navigateBack(); // Geri dön

                }

            }
        }
    }

    @Then("The opened page URL should match the button's href")
    public void verify_pages_open_correctly() {
    }

}
