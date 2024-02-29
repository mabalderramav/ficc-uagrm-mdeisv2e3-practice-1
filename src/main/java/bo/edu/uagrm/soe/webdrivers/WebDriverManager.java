package bo.edu.uagrm.soe.webdrivers;

import bo.edu.uagrm.soe.browsers.BrowserWebDriverTypes;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public final class WebDriverManager {
    private static WebDriverManager instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private io.github.bonigarcia.wdm.WebDriverManager webDriverManager;

    /**
     * Initializes an instance of {@link WebDriverManager}.
     */
    private WebDriverManager(BrowserWebDriverTypes webDriverType) {
        initializeDriver(webDriverType);
    }

    /**
     * Initializes the Singleton Driver Manager instance.
     *
     * @return singleton instance.
     */
    public static WebDriverManager getInstance(BrowserWebDriverTypes webDriverType) {
        if (Objects.isNull(instance)) {
            instance = new WebDriverManager(webDriverType);
        }
        return instance;
    }

    /**
     * Initializes the Web Driver instance.
     */
    private void initializeDriver(BrowserWebDriverTypes webDriverType) {
        webDriverManager = WebDriverFactory.getWebDriverManager(webDriverType);
        webDriver = webDriverManager.getWebDriver();
        webDriver.manage().window().setSize(new Dimension(1920, 1200));
        setDefaultTimeWaits();
    }

    /**
     * {@inheritDoc}
     */
    public void setDefaultTimeWaits() {
        setImplicitTimeWait(15);
        setExplicitTimeWait(15, 2);
        setPageLoadTimeWait(30);
    }

    /**
     * Sets implicit time wait.
     *
     * @param implicitTimeWait implicit time wait in seconds.
     */
    private void setImplicitTimeWait(final int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeWait));
    }

    /**
     * Sets explicit time wait.
     *
     * @param explicitTimeWait explicit time wait in seconds.
     * @param sleepTimeWait    sleep time wait in seconds.
     */
    private void setExplicitTimeWait(final int explicitTimeWait, final int sleepTimeWait) {

        webDriverWait = new WebDriverWait(
                webDriver, Duration.ofSeconds(explicitTimeWait), Duration.ofSeconds(sleepTimeWait));
    }

    /**
     * Sets page load time wait.
     *
     * @param pageLoadTimeWait page load time wait in seconds.
     */
    private void setPageLoadTimeWait(final long pageLoadTimeWait) {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeWait));
    }

    public void quitWebDriver() {
        webDriver.quit();
        webDriverManager.quit();
        webDriver = null;
        webDriverManager = null;
        webDriverWait = null;
        instance = null;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }
}
