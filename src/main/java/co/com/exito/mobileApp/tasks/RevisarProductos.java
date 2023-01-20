package co.com.exito.mobileApp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.BTN_CARRITO_COMPRAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RevisarProductos implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Click.on(BTN_CARRITO_COMPRAS)
    );
  }

  public static RevisarProductos enElCarrito(){
    return instrumented(RevisarProductos.class);
  }
}
