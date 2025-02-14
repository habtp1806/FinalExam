package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;

import static base.DriverManager.waitForElementToBeVisible;

public class MailPage extends BasePage {
    private final By confirmationEmailXPath = By.xpath("//td[contains(text(), 'Please confirm')]");
    private final By resetEmailXPath = By.xpath("//td[contains(text(), 'Please reset')]");
    private final By resetLinkXPath = By.xpath("//*[@class='email_body']//a[contains(@href,'PasswordReset')]");
    private final By confirmationLinkXPath = By.xpath("//a[contains(@href, 'saferailway')]");
    private final By emailBoxXPath = By.xpath("//span[@id='inbox-id']");
    private final By emailExtensionXPath = By.xpath("//select[@id='gm-host-select']");
    private final By setBtnXPath = By.xpath("//button[normalize-space()='Set']");
    private final By emailTxtBoxXPath = By.xpath("//span[@id='inbox-id']/input[@type='text']");
    private final By mailContentXPath = By.xpath("//div[@class='email_body']");

    private static String email;


    public void setMail(String name, String domain) {
        clickMailBox();
        enterMail(name);
        clickSetBtn();
        selectDomainMail(domain);
    }

    public void clickMailBox() {
        SeleniumHelper.clickElement(emailBoxXPath);
    }

    public void clickSetBtn() {
        SeleniumHelper.clickElement(setBtnXPath);
    }

    public static void switchToEmail() {
        DriverManager.driver.switchTo().window(email);
    }

    public String getMail() {
        WebElement emailElement = SeleniumHelper.findElement(emailBoxXPath);
        String emailAddress = emailElement.getText() + "@guerrillamail.com";
        System.out.println("Temporary Email Address: " + emailAddress);
        return emailAddress;
    }

    public void enterMail(String email) {
        SeleniumHelper.enter(emailTxtBoxXPath, email);
    }

    public void selectDomainMail(String domain) {
        SeleniumHelper.selectByVisibleText(emailExtensionXPath, domain);
    }

    public void getConFirmLinkMail() {
        waitForElementToBeVisible(confirmationEmailXPath, 50);
        SeleniumHelper.clickElement(confirmationEmailXPath);
        waitForElementToBeVisible(confirmationLinkXPath, 50);
        SeleniumHelper.clickElement(confirmationLinkXPath);
    }

    public String getResetPasswordToken() {
        String[] parts = SeleniumHelper.getElementText(mailContentXPath).split("The token is: ");
        if (parts.length > 1) {
            String[] tokenParts = parts[1].split("\\.");
            return tokenParts[0].trim();
        }
        return "";
    }

    public void clickResetLink() {
        waitForElementToBeVisible(resetEmailXPath, 50);
        SeleniumHelper.clickElement(resetEmailXPath);

        // Wait for the confirmation link to be visible and click it
        waitForElementToBeVisible(resetLinkXPath, 50);
        SeleniumHelper.clickElement(resetLinkXPath);
    }


}
