package co.com.exito.mobileApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;

public class InicialPage {

  public static final Target BTN_INGRESAR =
    Target.the("Botón ingresar")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/AppCompatButton_ingresar']");

  public static final Target BTN_REGISTRARSE =
    Target.the("Botón registrarse")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/AppCompatButton_registrarse']");
}
