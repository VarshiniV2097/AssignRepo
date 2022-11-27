package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SamplePO extends BasePO{
    public SamplePO(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='Docs & Series']")
    private WebElement docsMenuOption;

    @FindBy(css = "[title='empty newsroom']~div:last-child div p:nth-of-type(2)")
    private WebElement viralNewsTitle;

    @FindBy(tagName = "h1")
    private WebElement pageHeaderText;

    @FindBy(css = "[aria-label='Watch Viral News']")
    private WebElement watchNowButton;

    @FindBy(css = "h1 > span:last-child")
    private WebElement watchNowPageTitle;

    @FindBy(css = "[aria-label='Close sticky notification banner']")
    private WebElement closeIcon;

    @FindBy(css = "[aria-label='Load more SERIES content'] > span")
    private WebElement loadMoreButton;

    @FindBy(css = "h1~div p")
    private List<WebElement> listSeries;

    @FindBy(css = "[aria-label='TVO Today Home']")
    private WebElement logo;

    @FindBy(css = "[alt='TVO Today logo']")
    private WebElement logoAtFooter;

    public void clickOnDocMenuOptionFromHeader() throws InterruptedException {
        selenium.clickOn(docsMenuOption);
    }

    public String getViralNewsPageTitle(){
        return selenium.getText(viralNewsTitle);
    }

    public void clickOnSubMenuOptionByName(String menuName) throws InterruptedException {
        String xPath = "//span[text()='"+menuName+"']";
        selenium.clickOn(By.xpath(xPath));
    }

    public String getPageHeaderText() throws InterruptedException {
        selenium.hardWait(5);
        return selenium.getText(pageHeaderText);
    }

    public void clickOnWatchNowButton() throws InterruptedException {
        selenium.clickOn(watchNowButton);
    }

    public String getWatchNowPageTitle(){
        return selenium.getText(watchNowPageTitle);
    }


    public void clickOnCloseIcon() throws InterruptedException {
        selenium.click(closeIcon);
    }

    public boolean isLoadMoreButtonPresent(){
        selenium.pageScrollInView(loadMoreButton);
        return selenium.isElementPresent(loadMoreButton);
    }

    public void clickOnLoadMoreButton() throws InterruptedException {

        selenium.clickOn(loadMoreButton);
    }

    public int getListOfSeries(){
        int num = listSeries.size();
        return num;
    }

    public void clickOnAnySeriesByName(String name) throws InterruptedException {
        String xpath = "//p[text()='"+name+"']";
        selenium.clickOn(By.xpath(xpath));
    }

    public boolean isFooterSectionPresent(String name){
        String xpath = "//p[text()='"+name+"']";
        selenium.pageScrollInView(By.xpath(xpath));
        return selenium.isElementPresent(By.xpath(xpath));
    }

    public void clickOnSubOptionFromAllSectionByName(String name) throws InterruptedException {
        String xpathLocator = "//h2[text()='"+name+"']";
        selenium.clickOn(By.xpath(xpathLocator));
    }

    public boolean isSubSectionPresent(String name){
        String xpathLocator = "//h2[text()='"+name+"']";
        return selenium.isElementPresent(By.xpath(xpathLocator));
    }

    public boolean isLogoPresent(){
        return logo.isDisplayed();
    }

    public boolean isFooterLogoDisplayed(){
        return logoAtFooter.isDisplayed();
    }
}
