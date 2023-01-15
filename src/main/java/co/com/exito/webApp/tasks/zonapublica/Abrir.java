package co.com.exito.webApp.tasks.zonapublica;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Abrir implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    try{
      actor.attemptsTo(Open.url("https://www.exito.com/"));
    }catch (Exception e){
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static Abrir laPagina() {
    return instrumented(Abrir.class);
  }
}
