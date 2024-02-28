package bo.edu.uagrm.soe.badcode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerTest {
    @Test
    void searchesInGoogle() {
        // Initialize WebDriverManager for Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Go to page
        driver.get("https://www.google.com/");

        // Find Search TextBox WebElement
        WebElement searchBox = driver.findElement(By.id("APjFqb"));

        // Fill TextBox
        searchBox.sendKeys("qa-academy");

        // Find Search Button
        WebElement searchButton = driver.findElement(By.name("btnK"));

        // Avoid this sleep - bad code.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Click Search Button
        searchButton.click();

        // Assertions
        WebElement qaAcademyLink = driver.findElement(By.xpath("//h3[text()='QA Training']"));
        Assertions.assertEquals("QA Training", qaAcademyLink.getText());

        // Close the browser
        driver.quit();
    }
}
