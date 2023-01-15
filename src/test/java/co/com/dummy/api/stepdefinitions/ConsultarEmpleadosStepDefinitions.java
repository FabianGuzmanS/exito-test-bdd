package co.com.dummy.api.stepdefinitions;

import co.com.dummy.api.questions.ElCodigoRespuesta;
import co.com.dummy.api.tasks.ConsultarEmpleados;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultarEmpleadosStepDefinitions {
  @Cuando("^el consulta todos los empleados$")
  public void elConsultaTodosLosEmpleados() {
    theActorInTheSpotlight().attemptsTo(ConsultarEmpleados.almacenados());
  }

  @Entonces("^debe obtener la informacion de los empleados$")
  public void debeObtenerLaInformacionDeLosEmpleados() {
    theActorInTheSpotlight().should(seeThat(ElCodigoRespuesta.es(), equalTo(200)));
  }
}
