package testcases;

import base.BaseTest;
import enums.RailwayStation;
import enums.RailwayTab;
import enums.SeatType;
import model.BookTicket;
import model.User;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BookTicketPage;
import pages.LoginPage;
import pages.TicketPricePage;
import utils.DateUtils;

import static base.DriverManager.navigateToRailWay;
import static org.testng.AssertJUnit.assertTrue;

public class FTTC703Test extends BaseTest {
    private final BasePage basePage = new BasePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final TicketPricePage ticketPricePage = new TicketPricePage();
    @Test(description = "User can book ticket with known price")
    public void bookTicket()
    {
        String numTicket = "2";
        String nextDepartDate = DateUtils.calculateNextDepartDate(10);
        BookTicket ticket = new BookTicket(nextDepartDate, SeatType.HARD_SEAT, numTicket);
        User user = new User(email, password);
        navigateToRailWay();
        BasePage.clickTab(RailwayTab.LOGIN);
        loginPage.login(user);
        BasePage.clickTab(RailwayTab.TICKET_PRICE);
        ticketPricePage.chooseTrainDepart("Huế to Quảng Ngãi");
        ticketPricePage.chooseTypeSeat("Hard seat");
        bookTicketPage.bookTicket(ticket);
        boolean result = bookTicketPage.verifySelectedBooking(ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), null, null, "2");
        assertTrue("The booking should be verified correctly", result);



    }

}
