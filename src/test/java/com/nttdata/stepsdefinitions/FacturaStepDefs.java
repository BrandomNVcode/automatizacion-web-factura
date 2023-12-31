package com.nttdata.stepsdefinitions;

import com.nttdata.steps.FacturaStep;
import com.nttdata.steps.HomeStep;
import com.nttdata.steps.LoginStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FacturaStepDefs {

    private WebDriver driver;
    private Scenario scenario;
    private LoginStep loginStep;
    private HomeStep homeStep;
    private FacturaStep facturaStep;


    @Before(order = 0)
    public void setUp() {
        // setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        // Creamos el driver
        this.driver = new ChromeDriver();
        //Maximizamos la pantalla
        this.driver.manage().window().maximize();

        this.loginStep = new LoginStep(this.driver);
        this.homeStep = new HomeStep(this.driver);
        this.facturaStep = new FacturaStep(this.driver);
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        this.driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


    @Dado("me encuentro en la pagina de login de factura")
    public void meEncuentroEnLaPaginaLoginDeFactura() {
        this.driver.get("https://pe.facturacion.com/demo");
    }


    @Cuando("inicio sesion con las credenciales {string} y {string}")
    public void inicioSesionConLasCredencialesY(String username, String password) {
        this.loginStep.iniciarSesion(username, password);
    }

    @Entonces("valido el mensaje de {string}")
    public void validoElMensajeDe(String expect) {
        this.homeStep.validarMensajeBienvenida(expect);
    }

    @Cuando("doy clic en Ventas, Documentos Electrónicos y Factura")
    public void doyClicEnVentasDocumentosElectrónicosYFactura() {
        this.homeStep.irAFactura();
    }

    @Entonces("valido que me encuentro en {string}")
    public void validoQueMeEncuentroEn(String expect) {
        this.facturaStep.validarPaginaFactura(expect);
    }

    @Cuando("en el Encabezado doy clic para seleccionar un cliente")
    public void enElEncabezadoDoyClicParaSeleccionarUnCliente() {
        this.facturaStep.abrirModalClientes();
    }

    @Entonces("valido el modal con el mensaje {string}")
    public void validoElModalConElMensaje(String expect) {
        this.facturaStep.validarMensajeModalClientes(expect);
    }

    @Y("valido que exista mas de {int} o más clientes")
    public void validoQueExistaMasDeOMasCliente(int nClientes) {
        this.facturaStep.validarNumeroDeClientes(nClientes);
    }

    @Cuando("doy clic al cliente con el ruc {long}")
    public void doyClicAlClienteConElRuc(long RUC) {
        this.facturaStep.escogerCliente();
    }

    @Entonces("valido en el formulario del encabezado el numero de identidad {string} y el nombre {string}")
    public void validoEnElFormularioDelEncabezadoElNumeroDeIdentidadYElNombre(String RUC, String nombre) {
        this.facturaStep.validarCliente(RUC, nombre);
    }

    @Cuando("escogo el tipo de moneda a dolar americado")
    public void escogoElTipoDeMonedaADolarAmericado() {
        this.facturaStep.establecerMonedaADolarAmericano();
    }


    @Y("el tipo de cambio establesco a {string}")
    public void elTipoDeCambioEstablescoA(String tipoCambioStr) {
        this.facturaStep.establecerTipoDeCambio(tipoCambioStr);
    }

    @Y("el tipo de cambio a deposito cuenta")
    public void elTipoDeCambioADepositoCuenta() {
        this.facturaStep.establecerMegioDeCambio();
    }

    @Y("doy clic en el boton de escoger detalle")
    public void doyClicEnElBotonDeEscogerDetalle() {
        this.facturaStep.abrirModalDetalles();
    }

    @Entonces("valido que el modal tenga como titulo {string}")
    public void validoQueElModalTengaComoTitulo(String expect) {
        this.facturaStep.validarTextoDelModalDeDetalle(expect);
    }

    @Y("que exista más de un producto y servicio")
    public void queExistaMásDeUnProductoYServicio() {
        this.facturaStep.validarCantidadProdutosYServicios();
    }

    @Cuando("escogo el producto con codigo {string}")
    public void escogoElProductoConCodigo(String codigo) {
        this.facturaStep.escogerProducto(codigo);
    }

    @Entonces("en el formulario valido que el codigo de producto sea {string} y de descripcion {string}")
    public void enElFormularioValidoQueElCodigoDeProductoSeaYDeDescripcion(String codigo, String descripcion) {
        this.facturaStep.validarProductoSeleccionado(codigo, descripcion);
    }

    @Cuando("establesco la cantidad de {int} unidades")
    public void establescoLaCantidadDeUnidades(int unidades) {
        this.facturaStep.establecerCandidadDeProductos(unidades);
    }

    @Y("{int} porciento de descuento")
    public void porcientoDeDescuento(int descuento) {
        this.facturaStep.establecerDescuento(descuento);
    }

    @Y("doy clic en insertar")
    public void doyClicEnInsertar() {
        this.facturaStep.guardarDetalle();
    }

    @Entonces("valido que el producto se haya inertado con codigo {string}, descripcion {string} y {int} unidades")
    public void validoQueElProductoSeHayaInertadoConCodigoDescripcionYUnidades(String codigo, String desc, int unidades) {
        this.facturaStep.validarDetalleGuardado(codigo, desc, unidades);
    }

    @Cuando("escogo el metodo de pago a {string}")
    public void escogoElMetodoDePagoA(String metodo) {
        this.facturaStep.establecerMetodoPago(metodo);
    }

    @Y("la cantidad de cuotas en {int}")
    public void laCantidadDeCuotasEn(int nCuotas) {
        this.facturaStep.establecerNumeroDeCuotas(nCuotas);
    }

    @Entonces("valido el modal con texto {string}")
    public void validoElModalConTexto(String expect) {
        this.facturaStep.validarTextoConfirmacionMetodoPago(expect);
    }

    @Y("que el monto neto a repartir sea {string}")
    public void queElMontoNetoARepartirSea(String expect) {
        this.facturaStep.validarMontoNetoARepartir(expect);
    }

    @Cuando("doy clic en guardar")
    public void doyClicEnGuardar() {
        this.facturaStep.confirmarMetodoPago();
    }

    @Entonces("valido que se haya registrado")
    public void validoQueSeHayaRegistrado() {
        this.facturaStep.validarMetodoDePago();
    }

    @Cuando("doy clic en el boton emitir documento")
    public void doyClicEnElBotonEmitirDocumento() {
        this.facturaStep.emitirDocumento();
    }

    @Entonces("valido el mensaje final de {string}")
    public void validoElMensajeFinalDe(String expect) {
        this.facturaStep.validarTextoDocumentoEmitido(expect);
    }
}
