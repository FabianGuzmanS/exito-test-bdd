package co.com.exito.mobileApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

  public static final Target TXT_CORREO =
    Target.the("Campo de texto correo electronico")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/TextInputEditText_email']");

  public static final Target TXT_PASSWORD =
    Target.the("Campo de texto contraseña")
      .locatedBy("//*[@text='Contraseña']");

  public static final Target BTN_INGRESAR =
    Target.the("Botón ingresar")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/AppCompatButton_ingresar']");

}
