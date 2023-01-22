package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.models.AutenticacionUsuarioData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enviar implements Task {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(Enviar.class);
  private AutenticacionUsuarioData credenciales;

  public Enviar(AutenticacionUsuarioData credenciales) {
    this.credenciales = credenciales;
  }

  @Override
  @Step("{0} envia las credenciales de acceso")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        Enter.theValue(credenciales.getCorreo()).into(TXT_CORREO),
        Enter.theValue(credenciales.getPassword()).into(TXT_PASSWORD),
        Click.on(BTN_INGRESAR)
      );
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static Enviar lasCredenciales(AutenticacionUsuarioData credenciales) {
    return instrumented(Enviar.class, credenciales);
  }
}
