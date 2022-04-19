package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    @Before
    public void openBrowserLoginTest() {
        openBrowser("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void login(){
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginBtn= driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginBtn.click();

        String expectedMessage = "Secure Area";

        WebElement actualMessageElement= driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("tomsmith1");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginBtn= driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginBtn.click();

        String expectedMessage = "Your username is invalid!";

        WebElement actualMessageElement= driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageElement.getText().substring(0,25);

        System.out.println(actualMessage);

        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn= driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginBtn.click();

        String expectedMessage = "Your password is invalid!";

        WebElement actualMessageElement= driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageElement.getText().substring(0,25);

        System.out.println(actualMessage);

        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @After
    public void closeBrowserLoginTest(){
       // closeBrowser();
    }
}
