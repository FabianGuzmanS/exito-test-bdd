package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.interactions.EnElLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.exito.mobileApp.userinterface.zonapublica.InicialPage.BTN_INGRESAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Abrir {

  public static EnElLogin enElLogin(){
    return instrumented(EnElLogin.class);
  }
}
