package co.com.exito.mobileApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {

  public static final Target LBL_NOMBRE_PRODUCTO_CARRITO =
    Target.the("Label nombre producto")
      .locatedBy("//*[@class='android.widget.TextView' and @text = '{0}']");

}
