package co.com.dummy.api.tasks;

import co.com.dummy.api.interactions.ConsumirServicio;
import co.com.dummy.api.models.EditarEmpleadoData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditarEmpleado implements Task {

  private List<EditarEmpleadoData> editarEmpleadoDataList;

  public EditarEmpleado(List<EditarEmpleadoData> editarEmpleadoDataList) {
    this.editarEmpleadoDataList = editarEmpleadoDataList;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumirServicio.conPut(editarEmpleadoDataList.get(0).toString(), editarEmpleadoDataList.get(0).getId()));
  }

  public static EditarEmpleado conLaInformacion(List<EditarEmpleadoData> editarEmpleadoDataList) {
    return instrumented(EditarEmpleado.class, editarEmpleadoDataList);
  }
}
