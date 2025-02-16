package pages.components;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BaseComponent {

    public BaseComponent() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

}
