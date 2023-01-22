package co.com.exito.mobileApp.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.BTN_CARRITO_COMPRAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RevisarProductos implements Task {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(RevisarProductos.class);

  @Override
  @Step("{0} abre el carrito de compras")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(Click.on(BTN_CARRITO_COMPRAS));
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static RevisarProductos enElCarrito() {
    return instrumented(RevisarProductos.class);
  }
}
