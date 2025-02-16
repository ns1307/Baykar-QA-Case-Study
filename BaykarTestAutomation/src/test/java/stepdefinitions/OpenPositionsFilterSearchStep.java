package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.OpenPositionsPage;
import utilities.ConfigReader;
import utilities.Driver;
import io.cucumber.java.en.Given;
import utilities.Helper;
import utilities.JsoupScraper;
import java.util.Random;

import java.util.ArrayList;

public class OpenPositionsFilterSearchStep {
        private OpenPositionsPage openPositionsPage;

        ArrayList unitList=new ArrayList();
        ArrayList<String> positionList=new ArrayList();

        String selectedUnit;
        String selectedPosition;

        public OpenPositionsFilterSearchStep() {
            openPositionsPage = new OpenPositionsPage();
        }


    @Given("The user navigates to the open positions page in kariyer.baykartech")
    public void theUserNavigatesToTheOpenPositonsPageInKariyerBaykartech() {
        String url = ConfigReader.getProperty("BaykarKariyerOpenPositionsUrl");
        Driver.openURL(url);
    }

    @When("The user retrieves the list of available departments from the filters")
    public void theUserRetrievesTheListOfAvailableDepartmentsFromTheFilters() {
            //wait until filter element is loaded and get page source
            JsoupScraper jsoupScraper=new JsoupScraper(Driver.getPageSource(By.cssSelector("#myUL2 li")));
            Elements listItems = jsoupScraper.selectElements("#myUL2 li");
            for (Element li : listItems) {
                Element unit = li.selectFirst("label");
                unitList.add(unit.text());
            }
            Assert.assertFalse("No unit found for filtering.",unitList.isEmpty());
    }

    @And("The user selects a random department from the list")
    public void theUserSelectsARandomDepartmentFromTheList() {
        this.selectedUnit=unitList.get(new Random().nextInt(unitList.size())).toString();//Select random unit
    }

    @And("The user applies the selected department as a filter")
    public void theUserAppliesTheSelectedDepartmentAsAFilter() {
            try{
                //Click selected departmen from filters
                Driver.findElement(By.xpath("//label[contains(text(), '" + selectedUnit + "')]")).click();
                Helper.wait(1);
            }
            catch(Exception e){
                Assert.assertTrue(false);
            }

    }

    @Then("Only job postings related to the selected department should be displayed")
    public void onlyJobPostingsRelatedToTheSelectedDepartmentShouldBeDisplayed() {
        JsoupScraper jsoupScraper=new JsoupScraper(Driver.getPageSource());
        Elements workBoxes=jsoupScraper.selectElements(".workbox");
        positionList=new ArrayList<>();
        for (Element workBox : workBoxes) {
            String position = workBox.select("h3.size-xs4").text();
            positionList.add(position);

            String subHead = workBox.select(".subHead h4.size-xs4").text();
            Assert.assertEquals(selectedUnit, subHead);
        }
    }

    @And("The user selects a random position from the filtered job postings")
    public void theUserSelectsARandomPositionFromTheFilteredJobPostings() {
        this.selectedPosition=positionList.get(new Random().nextInt(positionList.size())).toString();//Select random position
    }

    @And("The user enters this position into the search box and performs a search")
    public void theUserEntersThisPositionIntoTheSearchBoxAndPerformsASearch() {
        openPositionsPage.searchBox.sendKeys(selectedPosition);
        Helper.wait(1);
    }

    @Then("The title of each job posting in the search results should exactly match or contain the searched position")
    public void theTitleOfEachJobPostingInTheSearchResultsShouldExactlyMatchOrContainTheSearchedPosition() {
        JsoupScraper jsoupScraper=new JsoupScraper(Driver.getPageSource());
        Elements workBoxes=jsoupScraper.selectElements(".workbox");
        positionList=new ArrayList<>();
        for (Element workBox : workBoxes) {
            String position = workBox.select("h3.size-xs4").text();
            Assert.assertTrue(position.toLowerCase().contains(selectedPosition.toLowerCase()));//The title should contain the selected position
            String subHead = workBox.select(".subHead h4.size-xs4").text();
            Assert.assertEquals(selectedUnit, subHead);//Units should belong to the selected unit
        }
    }


}
