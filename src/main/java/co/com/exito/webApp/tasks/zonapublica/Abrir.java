package co.com.exito.webApp.tasks.zonapublica;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Abrir implements Task {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(Abrir.class);
  @Override
  @Step("{0} abre la pagina en el navegador")
  public <T extends Actor> void performAs(T actor) {
    try{
      actor.attemptsTo(Open.url("https://www.exito.com/"));
    }catch (Exception e){
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static Abrir laPagina() {
    return instrumented(Abrir.class);
  }
}
