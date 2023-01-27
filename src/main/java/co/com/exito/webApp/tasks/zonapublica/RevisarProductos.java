package co.com.exito.webApp.tasks.zonapublica;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.exito.webApp.userinterface.zonapublica.HomePage.BTN_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RevisarProductos implements Task {

  @Override
  @Step("{0} abre el carrito de compras")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(BTN_CARRITO));
  }

  public static RevisarProductos enElCarrito() {
    return instrumented(RevisarProductos.class);
  }
}
