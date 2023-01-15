package co.com.dummy.api.tasks;

import co.com.dummy.api.interactions.ConsumirServicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarEmpleados implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumirServicio.conGet());
  }

  public static ConsultarEmpleados almacenados(){
    return instrumented(ConsultarEmpleados.class);
  }
}
