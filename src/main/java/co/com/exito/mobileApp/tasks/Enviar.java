package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.models.AutenticacionUsuarioData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.exito.mobileApp.userinterface.zonapublica.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enviar implements Task {
  private AutenticacionUsuarioData credenciales;

  public Enviar(AutenticacionUsuarioData credenciales) {
    this.credenciales = credenciales;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Enter.theValue(credenciales.getCorreo()).into(TXT_CORREO),
      Enter.theValue(credenciales.getPassword()).into(TXT_PASSWORD),
      Click.on(BTN_INGRESAR)
    );
  }

  public static Enviar lasCredenciales(AutenticacionUsuarioData credenciales){
    return instrumented(Enviar.class, credenciales);
  }
}
