package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.Hotel.HotelHomePage;
import org.testng.Assert;

public class HotelSD {

    private HotelHomePage homePage = new HotelHomePage();

    @Given("^I am on hotels.com home page$")
    public void iAmOnHomePage() throws InterruptedException {

        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
       homePage.closePopUp();
        Thread.sleep(2000);
        homePage.enterCityName("New York, New York, United States of America");
        homePage.clickSomeWhere();
        Thread.sleep(2000);
    }

    @Then("^I select rooms as \"([^\"]*)\"$")
    public void iSelectSelect_roomsFromRoomDropdown(String arg2) {
        homePage.selectDropDown(arg2);
    }

    @And("^I verify displayed \"([^\"]*)\"$")
    public void iVerifyDisplayed(String arg1) {
        homePage.verifyRoom(arg1);
    }

    @Then("^I click search button to get default locations search result screen$")
    public void searchButton () throws InterruptedException {
        homePage.clickOnSearchButton();
    }

    @Then("^I select property class \"([^\"]*)\"$")
    public void fiveStarSelect(String star) {

        homePage.selectStar(star);
    }

    @Then("^I verify hotels on search result system displays only (.+)")
    public void isStarDisplayed (String textField){
        switch (textField){
            case "5 star":
                homePage.fiveStar();
            case "4 star":
                homePage.fourStar();
            case "3 star":
                homePage.threeStar();
        }
        Assert.assertTrue(true);
    }

    @Then("^I verify todays deal is less than \\$(\\d+)$")
    public void iVerifyTodaysDealIsLessThan$(String arg0) {
        homePage.verifyDeal(arg0);
        Assert.assertTrue(true);
    }
}

