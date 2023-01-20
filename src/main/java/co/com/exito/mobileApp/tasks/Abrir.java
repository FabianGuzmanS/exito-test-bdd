package co.com.exito.mobileApp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.exito.mobileApp.userinterface.zonapublica.InicialPage.BTN_INGRESAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Abrir implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(BTN_INGRESAR));
  }

  public static Abrir ExitoApp(){
    return instrumented(Abrir.class);
  }
}
