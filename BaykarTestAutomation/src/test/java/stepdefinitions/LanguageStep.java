package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import pages.Homepage;
import pages.components.NavbarComponent;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JsoupScraper;

import java.util.*;

public class LanguageStep {


    private NavbarComponent navbar;
    private List<String> supportedLanguages;

    public LanguageStep() {
        navbar = new NavbarComponent();
    }


    @Given("User visits the Baykartech {} site and views the site in that language")
    public void user_visits_the_baykartech_site_and_views_the_site_in(String language) {
        String url = ConfigReader.getProperty("BaykarKariyerHomepage." + language);
        Driver.openURL(url);
        Assert.assertTrue("Page did not open for this language : " + language, Driver.getCurrentURL().contains(language));
    }

    @When("User clicks on the language change button")
    public void user_clicks_on_the_language_change_button() {
        navbar.languageButton.click();
    }

    @Then("the old language should appear on the button and the site URL should be different from old {}")
    public void the_other_language_should_appear_on_the_button_and_the_site_url_should_be_updated(String oldLanguage) {
        Assert.assertEquals("Language is not changed in Language Button", oldLanguage, navbar.languageButton.getText().toLowerCase());
        Assert.assertFalse("Language is not changed in the URL", Driver.getCurrentURL().contains(oldLanguage));
    }

    @Then("Page titles, menu items, and content should be updated to reflect the new language")
    public void page_titles_menu_items_and_content_should_be_updated_to_reflect_the_new_language() {
        Assert.assertEquals("Page content is not on the displayed language.", new Homepage().sloganTitle.getText(), "From the Roots");
        Assert.assertTrue("Page title is not on the displayed language.", Objects.requireNonNull(Driver.getDriver().getTitle()).contains("Home Page"));
    }

    @Given("The list of languages provided by the site is known")
    public void the_list_of_languages_provided_by_the_site_is_known() {
        this.supportedLanguages = ConfigReader.getPropertyAsList("languages");
    }


    @Given("User sees one of the languages from the list on the language change button")
    public void user_sees_one_of_the_languages_from_the_list_on_the_language_change_button() {
        String url = ConfigReader.getProperty("BaykarKariyerHomepage." + ConfigReader.getProperty("default.language"));
        Driver.openURL(url);
        String displayedLanguage = navbar.languageButton.getText().toLowerCase();
        Assert.assertTrue("Displayed language is not supported.", supportedLanguages.contains(displayedLanguage));
    }


    @Then("The supported languages in the HTML should match the known list")
    public void theSupportedLanguagesInTheHTMLShouldMatchTheKnownList() {
        JsoupScraper scraper = new JsoupScraper(Driver.getPageSource());
        Elements languageOptions = scraper.selectElements("div.offcanvas-button ul.dropdown-menu li a.dropdown-item");
        ArrayList<String> languages = new ArrayList<>();
        for (Element option : languageOptions) {
            String language = option.text().trim().toLowerCase();
            languages.add(language);
        }
        Collections.sort(languages);
        Collections.sort(supportedLanguages);
        Assert.assertEquals("Supported languages and displayed languages are not matched.", supportedLanguages, languages);
    }
}
