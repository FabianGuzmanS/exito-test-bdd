package co.com.dummy.api.stepdefinitions;

import co.com.dummy.api.models.CrearEmpleadoData;
import co.com.dummy.api.questions.ElCodigoRespuesta;
import co.com.dummy.api.tasks.CrearEmpleado;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static co.com.dummy.api.utils.RestService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearEmpleadoStepDefinitions {

  @Dado("^Fabian es el administrador de la pagina$")
  public void queSeQuiereCrearUnNuevoEmpleado() {
    theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL.toString()));
  }

  @Cuando("^envia la informacion requerida$")
  public void enviaLaInformacionRequerida(List<CrearEmpleadoData> data) {
    theActorInTheSpotlight().attemptsTo(CrearEmpleado.conLaInformacion(data));
  }

  @Entonces("^debe ver el empleado creado$")
  public void debeVerElEmpleadoCreado() {
    theActorInTheSpotlight().should(seeThat(ElCodigoRespuesta.es(),equalTo(200)));
  }
}
