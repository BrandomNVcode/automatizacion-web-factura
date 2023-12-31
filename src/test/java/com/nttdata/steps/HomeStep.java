package com.nttdata.steps;

import com.nttdata.page.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeStep {

    private WebDriver driver;

    public HomeStep(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }

    public void validarMensajeBienvenida(String expect) {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        String mensaje = driverIFr.findElement(HomePage.textBienvenida).getText();

        // Salimos del iframe
        driver.switchTo().defaultContent();

        Assertions.assertEquals(mensaje, expect);
    }

    public void irAFactura() {
        /*WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);*/

        this.driver.findElement(HomePage.navVentas).click();
        this.driver.findElement(HomePage.navDocElectronicos).click();
        this.driver.findElement(HomePage.navFactura).click();

    }
}
