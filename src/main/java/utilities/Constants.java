package utilities;

public class Constants
{
    public static final String PROPERTYFILE ="src/main/resources/constants.properties";

    //Setting up the URLs
    public static final String URL = JavaHelpers.getPropertyValue(PROPERTYFILE,"url");



    //Selenium constants
    public static final int WEBDRIVER_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE,"WebDriverWaitDuration"));
    public static final int MINIMUM_WEBDRIVER_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE,"MinimumWebDriverWaitDuration"));
    public static final int PAGEFACTORY_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE,"PageFactoryWaitDuration"));

    //Other
    public static final String SCREENSHOT_LOCATION= JavaHelpers.getPropertyValue(PROPERTYFILE,"ScreenshotLocation");



}