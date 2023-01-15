package co.com.exito.webApp.tasks.zonapublica;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.exito.webApp.userinterface.zonapublica.HomePage.BTN_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RevisarProductos implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(Click.on(BTN_CARRITO));
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static RevisarProductos enElCarrito() {
    return instrumented(RevisarProductos.class);
  }
}
