package framework.webPages.Hotel;
import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;


public class HotelHomePage extends BasePage {

    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By fiveStar = By.xpath("//input[@id='f-star-rating-5']");
    private By fourStar = By.xpath("//input[@id='f-star-rating-4']");
    private By threeStar = By.xpath("//input[@id='f-star-rating-3']");
    private By cityName = By.xpath("//input[@id='qf-0q-destination']");
    private By roomSelect = By.xpath("//select[@id='qf-0q-rooms']");
    private By clickOutSide = By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
    private By room2 = By.xpath("//span[contains(text(),'Room 2:')]");
    private By room3 = By.xpath("//span[contains(text(),'Room 3:')]");
    private By bestDeal = By.xpath("//h2[@class='header-text widget-tooltip widget-tooltip-br widget-tooltip-multiline']");
    private By verifyDealAmount = By.xpath("//ins[contains(text(),'$199')]");

    private By popup = By.xpath("//*[@id=\"managed-overlay\"]/button");


    public void closePopUp() {

        if (isElementDisplayed(popup)) {
            clickOn(popup);
        } else {
        }
    }

    public void enterCityName(String city) {
        setCity(cityName, city);
    }

    public void clickSomeWhere() {
        clickOn(clickOutSide);
    }


    public void selectDropDown(String room) {
        selectFromDropdown(roomSelect, room);
    }


    public void verifyRoom(String Rooms) {


        switch (Rooms) {
            case "Room 2:":
                String rm2 = getTextFromElement(room2);
                Assert.assertEquals(rm2, "Room 2:");
                break;
            case "Room 3:":
                String rm3 = getTextFromElement(room3);
                Assert.assertEquals(rm3, "Room 3:");
                Assert.fail();
                break;
        }
    }

    public void clickOnSearchButton() throws InterruptedException {
        clickOn(searchButton);
        Thread.sleep(20000);
    }

    public void selectStar(String Star) {
        switch (Star) {
            case "5 Stars":
                scrollDown();
                boolean star5 = isElementSelected(fiveStar);
                Assert.assertTrue(star5);
                break;
            case "4 Stars":
                scrollDown();
                boolean star4 = isElementSelected(fourStar);
                Assert.assertTrue(star4);
            case "3 Stars":
                scrollDown();
                boolean star3 = isElementSelected(threeStar);
                Assert.assertTrue(star3);
        }
    }

    public void fiveStar() {
        scrollDown();
        clickOn(fiveStar);
    }

    public void fourStar() {
        scrollDown();
        clickOn(fourStar);
    }

    public void threeStar() {
        scrollDown();
        clickOn(threeStar);
    }

    public boolean verify() {
        boolean trueOrFalse = false;
        if (isElementSelected(fiveStar)) {
            return true;
        }
        if (isElementSelected(fourStar)) {
            return true;
        }
        if (isElementSelected(threeStar)) {
            return true;
        } else
            return false;
        }

        public boolean verifyDeal(String deal) {
        boolean displayed = false;
        isElementSelected(bestDeal);
        return true;
        }

}

