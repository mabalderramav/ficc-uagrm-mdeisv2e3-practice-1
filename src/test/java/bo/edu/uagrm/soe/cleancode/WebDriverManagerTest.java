package bo.edu.uagrm.soe.cleancode;

import bo.edu.uagrm.soe.webdrivers.WebDriverManager;
import bo.edu.uagrm.soe.webdrivers.WebDriverTypes;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DisplayName("Web Driver Manager Test")
public class WebDriverManagerTest {
    public static final String GOOGLE_URL = "https://www.google.com/";

    private WebDriverManager webDriverManager;

    @AfterEach
    void tearDown() {
        webDriverManager.quitWebDriver();
    }

    @ParameterizedTest
    @DisplayName("Searches in Google")
    @Tag("UnitTest")
    @EnumSource(WebDriverTypes.class)
    void searchesInGoogle(WebDriverTypes webDriverType) {
        webDriverManager = WebDriverManager.getInstance(webDriverType);

        // Go to page
        webDriverManager.getWebDriver().navigate().to(GOOGLE_URL);

        // Find Search TextBox WebElement
        WebElement searchTextBox = webDriverManager.getWebDriver().findElement(By.id("APjFqb"));

        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.visibilityOf(searchTextBox));

        // Clear TextBox
        searchTextBox.clear();

        // Fill TextBox
        searchTextBox.sendKeys("qa-academy");

        // Find Search Button
        WebElement searchButton = webDriverManager.getWebDriver().findElement(By.name("btnK"));

        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));

        // Click on Search Button
        searchButton.click();

        // Assertions
        WebElement qaAcademyLink = webDriverManager.getWebDriver().findElement(By.xpath("//h3[text()='QA Training']"));
        Assertions.assertEquals("QA Training", qaAcademyLink.getText());
    }
}
