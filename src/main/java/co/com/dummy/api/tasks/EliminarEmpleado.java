package co.com.dummy.api.tasks;

import co.com.dummy.api.interactions.ConsumirServicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarEmpleado implements Task {

  private List<String> employeeIdList;

  public EliminarEmpleado(List<String> employeeIdList) {
    this.employeeIdList = employeeIdList;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumirServicio.conDelete(employeeIdList.get(0)));
  }

  public static EliminarEmpleado delRegistroDeActivos(List<String> employeeIdList){
    return instrumented(EliminarEmpleado.class, employeeIdList);
  }
}
