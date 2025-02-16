package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;
import java.util.List;

public class NavbarComponent extends BaseComponent {





    @FindBy(css = ".navbar-nav .nav-item")
    public List<WebElement> navBarElements;

    @FindBy(css ="li.nav-item.top-btn > a.nav-link")
    public WebElement languageButton;


}
