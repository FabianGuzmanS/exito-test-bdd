package co.com.exito.webApp.stepdefinitions.comunes;

import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.exito.webApp.utils.constantes.Constantes.ACTOR;

public class Hooks {

  private ComprasHandler comprasHandler = new ComprasHandler();

  @Before
  public void setTheStage(){
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled(ACTOR);
  }

  @After
  public void after(){
    comprasHandler.limpiarLista();
    Serenity.getWebdriverManager().getCurrentDriver().quit();
  }
}
