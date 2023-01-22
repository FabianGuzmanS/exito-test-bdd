package co.com.exito.mobileApp.stepdefinitions;

import co.com.exito.mobileApp.tasks.CerrarSesion;
import co.com.exito.mobileApp.utils.ComprasHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.exito.mobileApp.utils.Constantes.ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {

  ComprasHandler comprasHandler = new ComprasHandler();

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled(ACTOR);
  }

  @After
  public void after(){
    theActorInTheSpotlight().attemptsTo(CerrarSesion.enLaApp());
    comprasHandler.limpiarLista();
    Serenity.getWebdriverManager().getWebdriver().quit();
  }

}
