package Sample;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobject.SamplePO;
import utilities.Constants;

public class SampleTest extends BaseTest {


    @Test(priority = 1)
    public void verifyThatViralNewsPageGetsOpen() throws InterruptedException {

        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();

        Reporter.log("Step 3 - Verify that Viral News Page Gets open");
        Assert.assertEquals(sample.getViralNewsPageTitle(), "Viral News", "Page Title is not displayed");
    }

    @Test(priority = 2)
    public void verifyThatRelatedPagesGetsOpenFromDocsAndSeriesOption() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();

        Reporter.log("Step 3 - Click on Series Option from sub header");
        sample.clickOnSubMenuOptionByName("Series");

        Reporter.log("Step 4 - Verify that Series page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "SERIES", "Page Header is not matched");

        Reporter.log("Step 3 - Click on Docs Option from sub header");
        sample.clickOnSubMenuOptionByName("Docs");

        Reporter.log("Step 4 - Verify that Docs page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "DOCS", "Page Header is not matched");


        Reporter.log("Step 3 - Click on A-Z Option from sub header");
        sample.clickOnSubMenuOptionByName("A-Z");

        Reporter.log("Step 4 - Verify that A-Z page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "A-Z", "Page Header is not matched");


        Reporter.log("Step 3 - Click on TVO Originals Option from sub header");
        sample.clickOnSubMenuOptionByName("TVO Originals");

        Reporter.log("Step 4 - Verify that TVO Originals page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "TVO ORIGINALS", "Page Header is not matched");
    }

    @Test(priority = 3)
    public void verifyThatUserRedirectedToVideoPageWhenClickOnWatchNowButton() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Click on Watch Now Button");
        sample.clickOnWatchNowButton();

        Assert.assertEquals(selenium.getURL() ,"https://www.tvo.org/video/documentaries/viral-news", "Page is not open");
        Assert.assertEquals(sample.getWatchNowPageTitle(), "Viral News", "Header is not matched");
    }

    @Test(priority = 4)
    public void verifyThatLoadMoreButtonIsDisplayedOnSeriesPage() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Click on Series Option from sub header");
        sample.clickOnSubMenuOptionByName("Series");

        Reporter.log("Step 4 - Verify that Series page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "SERIES", "Page Header is not matched");

        Reporter.log("Step 5 - Verify that Load More button displayed");
        Assert.assertTrue(sample.isLoadMoreButtonPresent(), "Button is not displayed");
    }

    @Test(priority = 5)
    public void verifyThatLoadMoreButtonWorkSuccessfully() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Click on Series Option from sub header");
        sample.clickOnSubMenuOptionByName("Series");

        Reporter.log("Step 4 - Verify that Series page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "SERIES", "Page Header is not matched");

        int seriesNumber = sample.getListOfSeries();
        Reporter.log("Step 4 - Click on Load more Button");
        sample.clickOnLoadMoreButton();

        Reporter.log("Step 5 - Verify that more series load");
        Assert.assertTrue(sample.getListOfSeries()>seriesNumber, "Load More button is not working");
    }

    @Test(priority = 6)
    public void verifyThatCorrectPageGetsOpenFromSeriesPage() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Click on Series Option from sub header");
        sample.clickOnSubMenuOptionByName("Series");

        Reporter.log("Step 4 - Verify that Series page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "SERIES", "Page Header is not matched");

        Reporter.log("Step 5 - Click on any Series  by name");
        sample.clickOnAnySeriesByName("A Stitch in Time");

        Reporter.log("Step 6 - Verify that correct page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "A Stitch in Time", "Page Header is not matched");
    }

    @Test(priority = 7)
    public void verifyThatTVOSectionsArePresentInFooter() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Verify that Footer sections are present");
        Assert.assertTrue(sample.isFooterSectionPresent("Connect with TVO"), "Section is not present");
        Assert.assertTrue(sample.isFooterSectionPresent("Explore TVO"), "Section is not present");
        Assert.assertTrue(sample.isFooterSectionPresent("Work with TVO"), "Section is not present");
    }

    @Test(priority = 8)
    public void verifyThatUserRedirectedSubOptionsFromAllSectionPage() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Click on sub Section option from All Section");
        sample.clickOnSubOptionFromAllSectionByName("Art");

        Reporter.log("Step 4 - Verify Page gets open");
        Assert.assertEquals(sample.getPageHeaderText(), "ART", "Page Header is not matched");
    }

    @Test(priority = 9)
    public void verifyThatSubSectionsArePresentOnAllSectionPage() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Verify that sub sections are present on the All Section Page");
        Assert.assertTrue(sample.isSubSectionPresent("Recently Added"));
        Assert.assertTrue(sample.isSubSectionPresent("Remembering"));
        Assert.assertTrue(sample.isSubSectionPresent("Apocalypse: World War I"));
    }

    @Test(priority = 10)
    public void verifyThatLogoIsDisplayedOnTheHeaderAndFooter() throws InterruptedException {
        SamplePO sample = new SamplePO(driver);
        Reporter.log("Step 1 - Navigate to the application URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2 - Click on Docs & Series Option from header");
        sample.clickOnDocMenuOptionFromHeader();
        sample.clickOnCloseIcon();

        Reporter.log("Step 3 - Verify Logo is displayed on the header");
        Assert.assertTrue(sample.isLogoPresent(), "Logo is not displayed on header");

        Reporter.log("Step 3 - Verify Logo is displayed on the footer");
        Assert.assertTrue(sample.isFooterLogoDisplayed(), "Logo is not displayed on footer");
    }
}
