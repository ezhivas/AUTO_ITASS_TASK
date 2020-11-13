import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PostTaskMeta {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://webmail.meta.ua/");
        String sender = "Чередник Андрей";
        String messageThemeToCheck = "test email task";
        WebElement loginField = driver.findElement(By.id("login-field"));
        WebElement passwordField = driver.findElement(By.id("pass-field"));
        loginField.sendKeys("check.red@meta.ua");
        passwordField.sendKeys("z18xer");
        WebElement loginButton = driver.findElement((By.id("loginbtnua")));
        loginButton.click();
        WebElement composeMail = driver.findElement(By.id("id_send_email"));
        composeMail.click();
        WebElement sendTo = driver.findElement(By.id("send_to"));
        WebElement themeField = driver.findElement(By.id("subject"));
        WebElement buttonSend = driver.findElement(By.xpath("//input[@name='send']"));
        WebElement messageBody = driver.findElement(By.id("body"));
        sendTo.sendKeys("check.red@meta.ua");
        themeField.sendKeys("test email task");
        messageBody.sendKeys("Some text");
        buttonSend.click();
        WebElement buttonCheckMail = driver.findElement(By.id("id_check_email"));
        buttonCheckMail.click();
        WebElement element = driver.findElement(By.xpath("//table[@id='messlist']/tbody/tr[2]/td[1]"));
        String fromWho = driver.findElement((By.xpath("//table[@id='messlist']/tbody/tr[2]/td[4]"))).getText();
        String messageTheme = driver.findElement((By.xpath("//table[@id='messlist']/tbody/tr[2]/td[5]"))).getText();
        Assert.assertEquals(fromWho, sender);
        Assert.assertEquals(messageTheme, messageThemeToCheck);
    }
}
