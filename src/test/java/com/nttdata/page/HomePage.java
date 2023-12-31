package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {

    public static By textBienvenida = By.xpath("//p[normalize-space()='Gracias por visitar nuestro sistema.']");

    public static By navVentas = By.xpath("//a[@id='link_4']");
    public static By navDocElectronicos = By.xpath("//a[@id='link_10']");
    public static By navFactura = By.xpath("//a[@id='link_12']");

}
