package co.com.exito.mobileApp.userinterface.zonapublica;


import net.serenitybdd.screenplay.targets.Target;

public class MiCuentaPage {

  public static final Target BTN_CERRAR_SESION =
    Target.the("Botón cerrar sesión")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/appCompatTextView' and @text='Cerrar sesión']");

  public static final Target BTN_ACEPTAR_POPUP =
    Target.the("Botón aceptar del popUp")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/AppCompatTextView_confirmar']");
}
