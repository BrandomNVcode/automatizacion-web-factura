package com.nttdata.steps;

import com.nttdata.page.FacturaPage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class FacturaStep {

    private WebDriver driver;

    public FacturaStep(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarPaginaFactura(String expect) {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        String mensaje = driverIFr.findElement(FacturaPage.textFactura).getText();

        // salir del iframe
        driver.switchTo().defaultContent();

        Assert.assertEquals(expect, mensaje);
    }

    public void abrirModalClientes() {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        driverIFr.findElement(FacturaPage.btnBuscarClientes).click();

        // salir del iframe
        driver.switchTo().defaultContent();
    }

    public void validarMensajeModalClientes(String expect) {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        WebElement iframe2 = driverIFr.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe2);


        String mensaje = driverIFr.findElement(FacturaPage.textBuscarClientes).getText();

        // salir del iframe
        driver.switchTo().defaultContent();

        Assert.assertEquals(expect, mensaje);
    }

    public void validarNumeroDeClientes(int nClientes) {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        WebElement iframe2 = driverIFr.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe2);


        List<WebElement> items = driverIFr.findElements(FacturaPage.listClientes);
        int cantidad = items.size();

        // salir del iframe
        driver.switchTo().defaultContent();

        Assertions.assertTrue(cantidad >= nClientes, "El tamaño es: " + cantidad);
    }

    public void escogerCliente() {
        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        WebElement iframe2 = driverIFr.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe2);


        driverIFr.findElement(FacturaPage.cliente).click();

        // salir del iframe
        this.driver.switchTo().defaultContent();
    }

    public void validarCliente(String ruc, String nombre) {
        try { // espero un tiempo para q carge la informacion
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriver driverIFr = this.driver;
        //Store the web element
        WebElement iframe = driverIFr.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        driverIFr.switchTo().frame(iframe);

        String cliente_ruc = driverIFr.findElement(FacturaPage.ruc_cliente).getAttribute("value");
        String cliente_nombre = driverIFr.findElement(FacturaPage.nombre_cliente).getAttribute("value");

        Assert.assertEquals(ruc, cliente_ruc);
        Assert.assertEquals(nombre, cliente_nombre);

        // salir del iframe
        this.driver.switchTo().defaultContent();
    }

    public void establecerMonedaADolarAmericano() {
        //Store the web element
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.selectMoneda).click();
        this.driver.findElement(FacturaPage.optionDolarAmericano).click();

        // salir del iframe
        this.driver.switchTo().defaultContent();
    }

    public void establecerTipoDeCambio(String tipoCambio) {
        //Store the web element
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        //Switch to the frame
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.inputTipoCambio).sendKeys(tipoCambio);

        // salir del iframe
        this.driver.switchTo().defaultContent();
    }

    public void establecerMegioDeCambio() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.selectMedioPago).click();
        this.driver.findElement(FacturaPage.optionDepositoCuenta).click();

        this.driver.switchTo().defaultContent();
    }

    public void abrirModalDetalles() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.btnBuscarDetalles).click();

        this.driver.switchTo().defaultContent();
    }


    public void validarTextoDelModalDeDetalle(String expect) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        this.driver.switchTo().frame(iframe2);

        String textoDetalle = this.driver.findElement(FacturaPage.textDetalles).getText();
        Assert.assertEquals(expect, textoDetalle);

        this.driver.switchTo().defaultContent();
    }

    public void validarCantidadProdutosYServicios() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        this.driver.switchTo().frame(iframe2);

        List<WebElement> items = this.driver.findElements(FacturaPage.listDetalles);
        int cantidad = items.size();

        this.driver.switchTo().defaultContent();

        Assert.assertTrue(cantidad > 0);
    }

    public void escogerProducto(String codigo) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='frm_LightboxPop']"));
        this.driver.switchTo().frame(iframe2);

        this.driver.findElement(FacturaPage.getDetalle(codigo)).click();

        this.driver.switchTo().defaultContent();
    }

    public void validarProductoSeleccionado(String codigo, String descripcion) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        String codigo_prod = this.driver.findElement(FacturaPage.inputCodProducto).getAttribute("value");
        String desc_prod = this.driver.findElement(FacturaPage.textareaDescProducto).getAttribute("value");

        this.driver.switchTo().defaultContent();

        Assert.assertEquals(codigo, codigo_prod);
        Assert.assertEquals(descripcion, desc_prod);
    }

    public void establecerCandidadDeProductos(int unidades) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.inputCantidad).clear();
        this.driver.findElement(FacturaPage.inputCantidad).sendKeys(unidades+"");

        this.driver.switchTo().defaultContent();
    }

    public void establecerDescuento(int descuento) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.inputDescuento).clear();
        this.driver.findElement(FacturaPage.inputDescuento).sendKeys(descuento+"");

        this.driver.switchTo().defaultContent();
    }

    public void guardarDetalle() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.btnGuardarDetalle).click();

        this.driver.switchTo().defaultContent();
    }

    public void validarDetalleGuardado(String codigo, String descripcion, int unidades) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        String codigo_prod = this.driver.findElement(FacturaPage.textCodigoDetalleGuardado).getText();
        String desc_prod = this.driver.findElement(FacturaPage.textDescDetalleGuardado).getText();
        String unidades_prod = this.driver.findElement(FacturaPage.textCantidadDetalleGuardado).getText();

        this.driver.switchTo().defaultContent();

        Assert.assertEquals(codigo, codigo_prod);
        Assert.assertEquals(descripcion, desc_prod);
        Assert.assertEquals(unidades+"", unidades_prod);
    }

    public void establecerMetodoPago(String metodo) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.selectMetodoPago).click();
        this.driver.findElement(FacturaPage.optionMetodoPago(metodo)).click();

        this.driver.switchTo().defaultContent();
    }

    public void establecerNumeroDeCuotas(int nCuotas) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.inputNCuotas).clear();
        this.driver.findElement(FacturaPage.inputNCuotas).sendKeys(nCuotas+"");
        this.driver.findElement(FacturaPage.btnGuardarMetodoPago).click();

        this.driver.switchTo().defaultContent();
    }

    public void validarTextoConfirmacionMetodoPago(String expect) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);
        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='contratos']"));
        this.driver.switchTo().frame(iframe2);

        String texto = this.driver.findElement(FacturaPage.textConfirmacionMetodoPago).getText();

        this.driver.switchTo().defaultContent();

        Assert.assertEquals(expect, texto);
    }

    public void validarMontoNetoARepartir(String expect) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);
        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='contratos']"));
        this.driver.switchTo().frame(iframe2);

        String texto = this.driver.findElement(FacturaPage.textMontoNetoARepartir).getText();

        this.driver.switchTo().defaultContent();

        Assert.assertTrue(texto.contains(expect));
    }

    public void confirmarMetodoPago() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);
        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='contratos']"));
        this.driver.switchTo().frame(iframe2);

        this.driver.findElement(FacturaPage.btnConfirmarMetodoPago).click();

        this.driver.switchTo().defaultContent();
    }

    public void validarMetodoDePago() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        String textNumPago = this.driver.findElement(FacturaPage.spanMetodoPagoGuardado).getText();

        this.driver.switchTo().defaultContent();

        Assert.assertTrue(Integer.parseInt(textNumPago) > 0);
    }

    public void emitirDocumento() {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);

        this.driver.findElement(FacturaPage.btnEmitirDocumento).click();

        this.driver.switchTo().defaultContent();
    }

    public void validarTextoDocumentoEmitido(String expect) {
        WebElement iframe = this.driver.findElement(By.xpath("//iframe[@id='INCLUD_FORM']"));
        this.driver.switchTo().frame(iframe);
        WebElement iframe2 = this.driver.findElement(By.xpath("//iframe[@id='iframe_msgbox']"));
        this.driver.switchTo().frame(iframe2);

        String textDocEmitido = this.driver.findElement(FacturaPage.textDocEmitido).getText();

        this.driver.switchTo().defaultContent();

        Assert.assertEquals(expect, textDocEmitido);
    }
}
