package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginStep {

    private WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }

    public void iniciarSesion(String username, String password) {
        this.driver.findElement(LoginPage.inputUsername).sendKeys(username);
        this.driver.findElement(LoginPage.inputPassword).sendKeys(password);
        this.driver.findElement(LoginPage.btnSubmit).click();
    }
}
