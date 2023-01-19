#language: es
Característica: Agregar productos al carrito de compras
  Yo como usuario de la Tienda Exito Web
  Quiero agregar productos al carro de compras
  Para validar los productos añadidos antes de pagar

  Esquema del escenario: : Agregar 5 productos al carro de compras
    Dado el usuario quiere comprar productos en Tiendas Exito web
    Cuando el agrega productos al carrito de compras
      | categoria   | subCategoria   | numeroProductos   |
      | <categoria> | <subCategoria> | <numeroProductos> |
    Entonces debera ver en el carrito, los productos agregados
    Y ver el mismo nombre de los productos agregados, en el carrito de compras
    Y ver el precio total de los productos agregados
    Y ver la cantidad de cada producto de acuerdo a lo agregado

    Ejemplos:
      | categoria  | subCategoria              | numeroProductos |
      | Tecnología | Computadores y accesorios | 5               |
      | Mercado    | Licores                   | 5               |
