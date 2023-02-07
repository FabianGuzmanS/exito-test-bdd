package co.com.dummy.api.stepdefinitions;


import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.dummy.api.utils.Constantes.ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

  @Before
  public void setTheStage(){
    OnStage.setTheStage(new OnlineCast());
    theActorCalled(ACTOR);
  }
}
