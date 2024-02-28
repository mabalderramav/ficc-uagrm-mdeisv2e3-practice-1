package bo.edu.uagrm.soe.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDocker implements Browser<WebDriverManager> {

    /**
     * Initializes an instance of {@link Chrome}.
     */
    public ChromeDocker() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriverManager getDriver() {
        WebDriverManager webDriverManager = WebDriverManager.chromedriver().browserInDocker();

        webDriverManager.create();
        return webDriverManager;
    }
}
