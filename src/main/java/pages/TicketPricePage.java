package pages;

import org.openqa.selenium.By;
import utils.SeleniumHelper;

public class TicketPricePage extends BasePage{

    private String trainDepartXpath="//tr[td/li[text()='%s']]//a[contains(@href, 'TicketPricePage')]";
    private final String seatXPath = "//*[@id='content']/table/tbody/tr[td[text()='%s']]//a[@class='BoxLink'][normalize-space()='Book ticket']";
    public void chooseTrainDepart(String departStation) {
        String xpathExpression = String.format(trainDepartXpath, departStation);
        By departTrain = By.xpath(xpathExpression);
        SeleniumHelper.scrollToElement(departTrain);
        SeleniumHelper.clickElement(departTrain);

    }
    public void chooseTypeSeat(String typeSeat) {
        String xpathExpression = String.format(seatXPath, typeSeat);
        By chooseSeat = By.xpath(xpathExpression);
        SeleniumHelper.clickElement(chooseSeat);
    }


}
