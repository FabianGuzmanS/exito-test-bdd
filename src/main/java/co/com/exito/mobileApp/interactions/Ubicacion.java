package co.com.exito.mobileApp.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.*;
import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.BTN_CONTINUAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;

public class Ubicacion implements Interaction {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(Ubicacion.class);

  @Override
  @Step("{0} selecciona la ubicación para recoger las compras")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        Click.on(BTN_COMPRAS),
        Click.on(OPT_COMPRA_RECOGE),
        Click.on(DDL_CIUDAD),
        Click.on(DDLOPT_CIUDAD.of("Bogotá, D.c.")),
        Click.on(DDL_ALMACEN),
        Click.on(DDLOPT_ALMACEN.of("EXITO Usme")),
        Click.on(BTN_CONTINUAR),
        WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(10).seconds(),
        WaitUntil.the(POPUP_INFO_ACTUALIZADA, isNotCurrentlyVisible()).forNoMoreThan(10).seconds(),
        Click.on(BTN_CONTINUAR)
      );
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }
}
