package co.com.exito.webApp.tasks.zonapublica;

import co.com.exito.webApp.models.TipoProductoData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.exito.webApp.userinterface.zonapublica.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Seleccionar implements Task {

  private TipoProductoData data;

  public Seleccionar(TipoProductoData data) {
    this.data = data;
  }

  @Override
  @Step("{0} selecciona una categoría y subcategoría del menú")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        WaitUntil.the(BTN_MENU, isVisible()).forNoMoreThan(10).seconds(),
        Click.on(BTN_MENU),
        WaitUntil.the(OPT_CATEGORIA.of(data.getCategoria()), isVisible()).forNoMoreThan(10).seconds(),
        Click.on(OPT_CATEGORIA.of(data.getCategoria())),
        WaitUntil.the(LNK_SUBCATEGORIA.of(data.getSubCategoria()), isVisible()).forNoMoreThan(10).seconds(),
        Click.on(LNK_SUBCATEGORIA.of(data.getSubCategoria()))
      );
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static Seleccionar unaSubcategoria(TipoProductoData data) {
    return instrumented(Seleccionar.class, data);
  }
}
