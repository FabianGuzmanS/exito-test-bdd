package co.com.exito.mobileApp.stepdefinitions;

import co.com.exito.mobileApp.models.AutenticacionUsuarioData;
import co.com.exito.mobileApp.models.PerfilUsuarioData;
import co.com.exito.mobileApp.questions.ElNombreDeUsuario;
import co.com.exito.mobileApp.tasks.Abrir;
import co.com.exito.mobileApp.tasks.Enviar;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticarseStepDefinitions {

  @Dado("^el usuario ingreso a la aplicación$")
  public void elUsuarioIngresoALaAplicacion() {
    theActorInTheSpotlight().wasAbleTo(Abrir.ExitoApp());
  }

  @Cuando("^envia la información requerida$")
  public void enviaLaInformacionRequerida(DataTable credenciales) {
    theActorInTheSpotlight().attemptsTo(Enviar.lasCredenciales(AutenticacionUsuarioData.setData(credenciales).get(0)));
  }

  @Entonces("^debe ver el perfil de usuario cargado$")
  public void debeVerElPerfilDeUsuarioCargado(DataTable perfil) {
    theActorInTheSpotlight().should(seeThat(ElNombreDeUsuario.enLaPaginaDeInicio(PerfilUsuarioData.setData(perfil).get(0))));
  }


}
