#language: es
Característica: Agregar productos al carrito de compras
  Yo como usuario de la app Exito
  Quiero agregar productos al carro de compras
  Para validar los productos añadidos antes de pagar

  Esquema del escenario: Agregar 1 producto al carro
    Dado que el usuario se autentico con sus credenciales
      | correo   | password   |
      | <correo> | <password> |
    Cuando el agrega un producto al carro de compras
      | categoria   | subCategoria   |
      | <categoria> | <subCategoria> |
    Entonces debe ver el producto en el carrito de compras
    Ejemplos:
      | correo                   | password  | categoria | subCategoria |
      | fabianPrueba@yopmail.com | Prueba123 | Mercado   | Snacks       |

