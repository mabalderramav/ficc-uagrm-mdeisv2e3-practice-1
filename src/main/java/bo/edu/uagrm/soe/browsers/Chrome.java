package bo.edu.uagrm.soe.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Initializes an instance of a Chrome web driver.
 */
public class Chrome implements Browser<WebDriverManager> {

    /**
     * Initializes an instance of {@link Chrome}.
     */
    public Chrome() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriverManager getDriver() {
        WebDriverManager webDriverManager;
        webDriverManager = WebDriverManager.chromedriver();
        webDriverManager.create();
        return webDriverManager;
    }
}
