package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class OpenPositionsPage extends BasePage {


    @FindBy(id = "search")
    public WebElement searchBox;


    @FindBy(className = "workBox")
    public List<WebElement> workBoxes;


}
