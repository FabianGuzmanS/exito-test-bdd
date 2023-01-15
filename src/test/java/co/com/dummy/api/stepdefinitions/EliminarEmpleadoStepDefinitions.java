package co.com.dummy.api.stepdefinitions;

import co.com.dummy.api.questions.ElCodigoRespuesta;
import co.com.dummy.api.tasks.EliminarEmpleado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EliminarEmpleadoStepDefinitions {
  @Cuando("^envia la solicitud de eliminación de usuario$")
  public void enviaLaSolicitudDeEliminaciónDeUsuario(List<String> idList) {
    theActorInTheSpotlight().attemptsTo(EliminarEmpleado.delRegistroDeActivos(idList));
  }


  @Entonces("^deberia obtener un resultado exitoso$")
  public void deberiaObtenerUnResultadoExitoso() {
    theActorInTheSpotlight().should(seeThat(ElCodigoRespuesta.es(), equalTo(200)));
  }
}
