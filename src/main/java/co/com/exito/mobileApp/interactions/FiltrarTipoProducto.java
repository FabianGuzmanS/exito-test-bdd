package co.com.exito.mobileApp.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.OPT_CATEGORIA;
import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.OPT_SUBCATEGORIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FiltrarTipoProducto implements Interaction {

  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(FiltrarTipoProducto.class);

  private String categoria;
  private String subCategoria;

  public FiltrarTipoProducto(String categoria, String subCategoria) {
    this.categoria = categoria;
    this.subCategoria = subCategoria;
  }

  @Override
  @Step("{0} filtra la busqueda de productos por categoría y sub categoría")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        Click.on(OPT_CATEGORIA.of(categoria)),
        Click.on(OPT_SUBCATEGORIA.of(subCategoria))
      );
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static FiltrarTipoProducto porSubCategoria(String categoria, String subCategoria) {
    return instrumented(FiltrarTipoProducto.class, categoria, subCategoria);
  }
}
