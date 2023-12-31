package com.nttdata.page;

import org.openqa.selenium.By;

public class FacturaPage {

    public static By textFactura = By.xpath("//td[contains(text(),'FACTURA ELECTRÓNICA Tipo (01)')]");
    public static By btnBuscarClientes = By.xpath("//button[@id='btnBuscar']");
    public static By textBuscarClientes = By.xpath("//td[contains(text(),'Buscador de Clientes')]");
    public static By listClientes = By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/div[4]/div[1]/div[2]/table[1]/tbody[1]");
    public static By cliente = By.xpath("//a[contains(text(),'10471320868')]");
    public static By ruc_cliente = By.xpath("//input[@id='txtruc']");
    public static By nombre_cliente = By.xpath("//input[@id='txtrazonsocial']");
    public static By selectMoneda = By.xpath("//select[@id='txtmoneda']");
    public static By optionDolarAmericano = By.xpath("//option[contains(text(),'DÓLAR AMERICANO')]");
    public static By inputTipoCambio = By.xpath("//input[@id='txtmonedacambio']");
    public static By selectMedioPago = By.xpath("//select[@id='txtmediodepago']");
    public static By optionDepositoCuenta = By.xpath("//option[contains(text(),'Depósito en cuenta')]");
    public static By btnBuscarDetalles = By.xpath("//tbody/tr[2]/td[1]/button[1]");
    public static By textDetalles = By.xpath("//td[contains(text(),'Productos y Servicios')]");
    public static By listDetalles = By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/div[4]/div[1]/div[2]/table[1]/tbody[1]");
    public static By getDetalle(String text) {return By.xpath("//a[contains(text(),'"+text+"')]");}
    public static By inputCodProducto = By.xpath("//input[@id='txtcodprod']");
    public static By textareaDescProducto = By.xpath("//textarea[@id='txtdescripcion']");
    public static By inputCantidad = By.xpath("//input[@id='txtcantidad']");
    public static By inputDescuento = By.xpath("//input[@id='txtvalordscrcg']");
    public static By btnGuardarDetalle = By.xpath("//button[@title='Guardar linea de detalle']");
    public static By textCodigoDetalleGuardado = By.xpath("//span[@id='detalle-cell-0-0']");
    public static By textDescDetalleGuardado = By.xpath("//span[@id='detalle-cell-1-0']");
    public static By textCantidadDetalleGuardado = By.xpath("//span[@id='detalle-cell-3-0']");
    public static By selectMetodoPago = By.xpath("//select[@id='selectmetodopago']");
    public static By optionMetodoPago(String metodo) {return By.xpath("//option[contains(text(),'"+metodo+"')]");}
    public static By inputNCuotas = By.xpath("//input[@id='txtncuota']");
    public static By btnGuardarMetodoPago = By.xpath("//button[@id='btningresarcuota']");
    public static By textConfirmacionMetodoPago = By.xpath("//td[contains(text(),'Monto Cuotas y Fecha de Vencimiento')]");
    public static By textMontoNetoARepartir = By.xpath("//div[contains(text(),'Monto neto a repartir')]");
    public static By btnConfirmarMetodoPago = By.xpath("//button[@id='btn_guardar']");
    public static By spanMetodoPagoGuardado = By.xpath("//span[@id='detalleFP-selector-0-box-text']");
    public static By btnEmitirDocumento = By.xpath("//button[@id='btn_emitir']");
    public static By textDocEmitido = By.xpath("//td[contains(text(),'Documento Emitido')]");

}
