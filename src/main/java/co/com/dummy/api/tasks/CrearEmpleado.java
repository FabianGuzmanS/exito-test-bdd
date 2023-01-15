package co.com.dummy.api.tasks;

import co.com.dummy.api.interactions.ConsumirServicio;
import co.com.dummy.api.models.CrearEmpleadoData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearEmpleado implements Task {

  private List<CrearEmpleadoData> crearEmpleadoDataList;

  public CrearEmpleado(List<CrearEmpleadoData> crearEmpleadoDataList) {
    this.crearEmpleadoDataList = crearEmpleadoDataList;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumirServicio.conPost(crearEmpleadoDataList.get(0).toString()));
  }

  public static CrearEmpleado conLaInformacion(List<CrearEmpleadoData> crearEmpleadoDataList){
    return instrumented(CrearEmpleado.class, crearEmpleadoDataList);
  }
}
