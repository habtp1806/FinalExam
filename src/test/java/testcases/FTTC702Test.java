package testcases;

import base.BaseTest;
import base.Config;
import base.DriverManager;
import enums.RailwayStation;
import enums.RailwayTab;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.BookTicket;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.DataUtils;

import static base.DriverManager.*;
import static org.testng.AssertJUnit.assertTrue;

public class FTTC702Test extends BaseTest {
    private static final RegisterPage registerPage = new RegisterPage();
    private static final MailPage mailPage = new MailPage();
    private static final LoginPage loginPage = new LoginPage();
    private static String registeredEmail;
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();

 @BeforeClass()
    public static void createAccount() {

         navigateToRailWay();
         BasePage.clickLink("create an account");
         String registerWindow = getWindowHandle();
         BasePage.openNewTab(Config.getProperty("tempmail.url"));
         registeredEmail = mailPage.getMail();
         String mailWindow = getWindowHandle();
         switchToWindow(registerWindow);
         BasePage.clickTab(RailwayTab.REGISTER);
         registerPage.register(registeredEmail, password, confirmPassword, pid);
         assertTrue("Confirm message is not present after register successfully.", registerPage.isConfirmationSuccessful());
         switchToWindow(mailWindow);
         refreshPage();
         mailPage.getConFirmLinkMail();
         BasePage.switchToRemainingTab(registerWindow, mailWindow);
         assertTrue("Registration Confirmed! You can now log in to the site", registerPage.isConfirmationRegister());


 }

    @Test(description = "User can filter Manage ticket table with both Arrive station and Depart date ", dataProvider = "bookTicketDataProvider", dataProviderClass = DataUtils.class)
    public void filterTicket(BookTicket ticket)
    {
        BookTicket filterTicketData= new BookTicket(RailwayStation.NHA_TRANG,"7/7/2024");
        User user = new User(email, password);
        navigateToRailWay();
        BasePage.clickTab(RailwayTab.LOGIN);
        loginPage.login(user);
        BasePage.clickTab(RailwayTab.BOOK_TICKET);
        bookTicketPage.bookTicket(ticket);
        BasePage.clickTab(RailwayTab.MY_TICKET);
        myTicketPage.filterTicket(filterTicketData);




    }
}
