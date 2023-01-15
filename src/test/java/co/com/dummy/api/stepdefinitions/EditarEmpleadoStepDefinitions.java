package co.com.dummy.api.stepdefinitions;

import co.com.dummy.api.models.CrearEmpleadoData;
import co.com.dummy.api.models.EditarEmpleadoData;
import co.com.dummy.api.questions.ElCodigoRespuesta;
import co.com.dummy.api.tasks.EditarEmpleado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EditarEmpleadoStepDefinitions {
  
  @Cuando("^envia la información editada del usuario$")
  public void enviaLaInformaciónEditadaDelUsuario(List<EditarEmpleadoData> data) {
    theActorInTheSpotlight().attemptsTo(EditarEmpleado.conLaInformacion(data));
  }

  @Entonces("^deberia ver la información actualizada$")
  public void deberiaVerLaInformaciónActualizada() {
    theActorInTheSpotlight().should(seeThat(ElCodigoRespuesta.es(), equalTo(200)));
  }
}
