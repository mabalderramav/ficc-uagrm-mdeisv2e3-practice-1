package bo.edu.uagrm.soe.webdrivers;

import bo.edu.uagrm.soe.browsers.Browser;
import bo.edu.uagrm.soe.browsers.Chrome;
import bo.edu.uagrm.soe.browsers.ChromeDocker;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.EnumMap;

/**
 * Creates the instance of a Web Driver.
 */
public final class WebDriverFactory {
    /**
     * Initializes an instance of {@link WebDriverFactory} utility class.
     */
    private WebDriverFactory() {
    }

    /**
     * Gets a Web Driver instances based in a Driver Type parameter.
     *
     * @param type Driver Type enum value.
     * @return Web Driver instance.
     */
    public static WebDriverManager getWebDriverManager(final WebDriverTypes type) {
        Browser<WebDriverManager> browser = getStrategyBrowser().get(type).performStep();
        return browser.getDriver();
    }

    /**
     * Gets strategy browser map.
     *
     * @return browser map.
     */
    private static EnumMap<WebDriverTypes, StrategyGetter<Browser<WebDriverManager>>> getStrategyBrowser() {
        EnumMap<WebDriverTypes, StrategyGetter<Browser<WebDriverManager>>> driverMap = new EnumMap<>(WebDriverTypes.class);
        driverMap.put(WebDriverTypes.CHROME, Chrome::new);
        driverMap.put(WebDriverTypes.CHROME_DOCKER, ChromeDocker::new);
        return driverMap;
    }
}
