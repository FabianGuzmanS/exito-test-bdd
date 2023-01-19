package co.com.exito.webApp.tasks.zonapublica;

import co.com.exito.webApp.interactions.Adicionar;
import co.com.exito.webApp.interactions.Comprar;
import co.com.exito.webApp.models.TipoProductoData;
import co.com.exito.webApp.questions.ElModal;
import co.com.exito.webApp.utils.Transversal.RandomGenerator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Agregar implements Task {

  private TipoProductoData data;
  SoftAssertions softAssertions = new SoftAssertions();
  private static final Logger logger = LoggerFactory.getLogger(Agregar.class);

  public Agregar(TipoProductoData data) {
    this.data = data;
  }

  RandomGenerator randomGenerator = new RandomGenerator();
  List<String> productos;

  @Override
  @Step("{0} agrega productos de una subcategoría")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        Check.whether(ElModal.deLocalizacionEsVisible())
          .andIfSo(
            Enter.theValue("Bogotá").into(TXT_CIUDAD),
            Hit.the(Keys.ENTER).into(TXT_CIUDAD),
            Enter.theValue("Chapinero").into(TXT_ALMACEN),
            Hit.the(Keys.ENTER).into(TXT_ALMACEN),
            Click.on(BTN_CONFIRMAR_LOCALIZACION)
          ));
      actor.attemptsTo(
        WaitUntil.the(PATH_PAGINA_ACTUAL, isPresent()).forNoMoreThan(20).seconds(),
        Scroll.to(PATH_PAGINA_ACTUAL),
        WaitUntil.the(BTN_VISTA_LISTA, isVisible()).forNoMoreThan(20).seconds(),
        Click.on(BTN_VISTA_LISTA),
        WaitUntil.the(LISTA_PRODUCTOS, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
        Scroll.to(LISTA_PRODUCTOS));
      int resultados = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//div[@class = 'exito-vtex-components-4-x-main']")).size();
      productos = randomGenerator.generarNumeroDeProducto(data.getNumeroProductos(), resultados);

      actor.attemptsTo(Check.whether(
          !Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//button[@type='button']//span[text()='Agregar']")).isEmpty())
        .andIfSo(
          Adicionar.deFormaMasiva(productos))
        .otherwise(
          Comprar.deFormaRapida(productos))
      );
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static Agregar productosAlCarrito(TipoProductoData data) {
    return instrumented(Agregar.class, data);
  }
}
