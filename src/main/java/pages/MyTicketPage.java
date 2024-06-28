package pages;

import base.Config;
import base.DriverManager;
import enums.RailwayStation;
import model.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;

public class MyTicketPage {
    private final By xpathMyTicketBtn =By.xpath("//input[@value='Apply filter']") ;

    public void filterTicket(BookTicket ticket ) {
       selectArriveAt(ticket.getArrivalStation());
        enterDepartDate(ticket.getDepartDate());
        clickApply();
    }
    private By getXPathByTextBox(String name) {
        return By.xpath(String.format("//input[@title='%s']", name));
    }
    private By getXPathByName(String name) {
        return By.xpath(String.format("//select[@name='%s']", name));
    }

    public void selectArriveAt(RailwayStation arriveStation) {
        SeleniumHelper.selectByVisibleText(getXPathByName("FilterArStation"), arriveStation.getValue());
    }
    public void enterDepartDate(String email) {
        SeleniumHelper.enter(getXPathByName("Empty = Ignore"), email);
    }
    public void clickApply() {

        SeleniumHelper.clickElement(xpathMyTicketBtn);
    }


}
