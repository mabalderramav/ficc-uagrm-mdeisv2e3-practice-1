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
    void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver d = new ChromeDriver();
        d.get("https://www.google.com/");
        WebElement sb = d.findElement(By.id("APjFqb"));
        sb.sendKeys("qa-academy");
        WebElement sb1 = d.findElement(By.name("btnK"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sb1.click();
        WebElement qaL = d.findElement(By.xpath("//h3[text()='QA Training']"));
        Assertions.assertEquals("QA Training", qaL.getText());
        d.quit();
    }
}
