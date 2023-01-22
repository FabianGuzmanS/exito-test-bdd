package co.com.exito.mobileApp.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.CarritoPage.BTN_ATRAS;
import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.BTN_MI_CUENTA;
import static co.com.exito.mobileApp.userinterface.zonapublica.MiCuentaPage.BTN_ACEPTAR_POPUP;
import static co.com.exito.mobileApp.userinterface.zonapublica.MiCuentaPage.BTN_CERRAR_SESION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CerrarSesion implements Task {

  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(CerrarSesion.class);

  @Override
  @Step("{0} cierra la sesión en la app")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        Check.whether(BTN_ATRAS.isVisibleFor(actor))
          .andIfSo(Click.on(BTN_ATRAS)),
        Click.on(BTN_MI_CUENTA),
        Click.on(BTN_CERRAR_SESION),
        WaitUntil.the(BTN_ACEPTAR_POPUP, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
        Click.on(BTN_ACEPTAR_POPUP)
      );
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static CerrarSesion enLaApp() {
    return instrumented(CerrarSesion.class);
  }
}
