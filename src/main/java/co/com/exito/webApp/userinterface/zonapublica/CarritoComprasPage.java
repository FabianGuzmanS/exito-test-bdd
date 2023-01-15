package co.com.exito.webApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoComprasPage {

  public static final Target LNK_NOMBRE_PRODUCTO =
    Target.the("Link label nombre del producto")
      .locatedBy("(//a[@class = 'exito-checkout-product-name'])[{0}]");

  public static final Target LBL_PRECIO_PRODUCTO =
    Target.the("Label precio del producto")
      .locatedBy("(//span[@class = 'new-product-price'])[{0}]");

  public static final Target LBL_PRECIO_TOTAL_PRODUCTO=
    Target.the("Label precio total del producto")
      .locatedBy("(//span[@class = 'total-selling-price'])[{0}]");

  public static final Target TXT_CANTIDAD_PRODUCTO =
    Target.the("Input cantidad del producto")
      .locatedBy("(//input[@class = 'exito-checkout-quantity'])[{0}]");

  public static final Target FILA_PRODUCTO =
    Target.the("Número de productos")
      .locatedBy("//tr[@class='product-item']");
}
