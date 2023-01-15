package co.com.exito.webApp.tasks.zonapublica;

import co.com.exito.webApp.interactions.Adicionar;
import co.com.exito.webApp.interactions.Comprar;
import co.com.exito.webApp.models.TipoProductoData;
import co.com.exito.webApp.utils.Transversal.RandomGenerator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Agregar implements Task {

  private TipoProductoData data;

  public Agregar(TipoProductoData data) {
    this.data = data;
  }

  RandomGenerator randomGenerator = new RandomGenerator();
  List<String> productos;

  @Override
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        WaitUntil.the(LISTA_PRODUCTOS, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
        Scroll.to(LISTA_PRODUCTOS));

      int productosCompraRapida = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("(//div[@class = 'exito-vtex-components-4-x-main'])//span[text()='Compra rápida']")).size();
      int prodcutosCompraSencilla = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("(//div[@class = 'exito-vtex-components-4-x-main'])//span[@class = 'exito-vtex-components-4-x-buttonText']")).size();

      if (prodcutosCompraSencilla == 0) {
        productos = randomGenerator.generarNumeroDeProducto(data.getNumeroProductos(), productosCompraRapida);
      } else {
        productos = randomGenerator.generarNumeroDeProducto(data.getNumeroProductos(), prodcutosCompraSencilla);
      }

      actor.attemptsTo(Check.whether(
          !Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("(//div[@class = 'exito-vtex-components-4-x-main'])//span[text()='Compra rápida']")).isEmpty())
        .andIfSo(
          Comprar.deFormaRapida(productos))
        .otherwise(
          Adicionar.deFormaMasiva(productos))
      );
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static Agregar productosAlCarrito(TipoProductoData data) {
    return instrumented(Agregar.class, data);
  }
}
