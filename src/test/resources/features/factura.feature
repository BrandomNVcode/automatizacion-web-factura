#language: es

  Característica: Generar factura de compra
  Yo, como usuario
  Quiero generar la compra de un producto
  Para generar una factura


  @test
  Escenario: Generar factura
    Dado me encuentro en la pagina de login de factura
    Cuando inicio sesion con las credenciales "" y ""
    Entonces valido el mensaje de "Gracias por visitar nuestro sistema."
    Cuando doy clic en Ventas, Documentos Electrónicos y Factura
    Entonces valido que me encuentro en "FACTURA ELECTRÓNICA Tipo (01)"
    Cuando en el Encabezado doy clic para seleccionar un cliente
    Entonces valido el modal con el mensaje "Buscador de Clientes"
    Y valido que exista mas de 1 o más clientes
    Cuando doy clic al cliente con el ruc 10471320868
    Entonces valido en el formulario del encabezado el numero de identidad "10471320868" y el nombre "SANCHEZ BAYLON MARIO JHOEL"
    Cuando escogo el tipo de moneda a dolar americado
    Y el tipo de cambio establesco a "3.8"
    Y el tipo de cambio a deposito cuenta
    Y doy clic en el boton de escoger detalle
    Entonces valido que el modal tenga como titulo "Productos y Servicios"
    Y que exista más de un producto y servicio
    Cuando escogo el producto con codigo "00001"
    Entonces en el formulario valido que el codigo de producto sea "00001" y de descripcion "POPELINA"
    Cuando establesco la cantidad de 50 unidades
    Y 10 porciento de descuento
    Y doy clic en insertar
    Entonces valido que el producto se haya inertado con codigo "00001", descripcion "POPELINA" y 50 unidades
    Cuando escogo el metodo de pago a "Crédito"
    Y la cantidad de cuotas en 1
    Entonces valido el modal con texto "Monto Cuotas y Fecha de Vencimiento"
    Y que el monto neto a repartir sea "11,682.00"
    Cuando doy clic en guardar
    Entonces valido que se haya registrado
    Cuando doy clic en el boton emitir documento
    Entonces valido el mensaje final de "Documento Emitido"




