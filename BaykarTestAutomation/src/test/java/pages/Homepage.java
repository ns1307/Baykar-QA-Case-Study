package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage extends BasePage {

    @FindBy(id = "pageTitle")
    public WebElement sloganTitle;


}
