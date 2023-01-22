package co.com.exito.mobileApp.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.InicialPage.BTN_INGRESAR;

public class EnElLogin implements Interaction {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(EnElLogin.class);

  @Override
  @Step("{0} abre la app en el Login")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(Click.on(BTN_INGRESAR));
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }
}
