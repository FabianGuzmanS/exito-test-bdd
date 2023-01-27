package co.com.exito.webApp.interactions;

import co.com.exito.webApp.models.DetalleProductoData;
import co.com.exito.webApp.utils.Transversal.RandomGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.*;
import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.LBL_PRECIO_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Adicionar implements Interaction {

  private List<String> numeroProductos;

  public Adicionar(List<String> numeroProductos) {
    this.numeroProductos = numeroProductos;
  }

  RandomGenerator randomGenerator = new RandomGenerator();

  @Override
  @Step("{0} adiciona productos al carro")
  public <T extends Actor> void performAs(T actor) {
    for (int i = 0; i < numeroProductos.size(); i++) {
      actor.attemptsTo(
        WaitUntil.the(BTN_AGREGAR.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
        Scroll.to(ART_PRODUCTO.of(numeroProductos.get(i))),
        WaitUntil.the(BTN_AGREGAR.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
        WaitUntil.the(BTN_AGREGAR.of(numeroProductos.get(i)), isCurrentlyVisible()).forNoMoreThan(20).seconds(),
        Click.on(BTN_AGREGAR.of(numeroProductos.get(i)))
      );
      int cantidad = randomGenerator.generarCantidades();
      for (int j = 0; j < cantidad - 1; j++) {
        actor.attemptsTo(
          WaitUntil.the(BTN_AUMENTAR_CANTIDAD.of(numeroProductos.get(i)), isCurrentlyVisible()).forNoMoreThan(20).seconds(),
          Click.on(BTN_AUMENTAR_CANTIDAD.of(numeroProductos.get(i))));
      }
      String nombreProducto = LBL_NOMBRE_PRODUCTO.of(numeroProductos.get(i)).resolveFor(actor).getText();
      String precioProducto = LBL_PRECIO_PRODUCTO.of(numeroProductos.get(i)).resolveFor(actor).getText();
      actor.remember(nombreProducto, new DetalleProductoData(precioProducto, String.valueOf(cantidad)));
    }
    actor.remember("Numero de productos", numeroProductos.size());
  }

  public static Adicionar deFormaMasiva(List<String> numeroProductos) {
    return instrumented(Adicionar.class, numeroProductos);
  }
}
