package co.com.exito.webApp.interactions;

import co.com.exito.webApp.models.DetalleProductoData;
import co.com.exito.webApp.utils.Transversal.RandomGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Comprar implements Interaction {

  private List<String> numeroProductos;

  public Comprar(List<String> numeroProductos) {
    this.numeroProductos = numeroProductos;
  }

  RandomGenerator randomGenerator = new RandomGenerator();

  @Override
  @Step("{0} adiciona productos al carro, con botón compra rapida")
  public <T extends Actor> void performAs(T actor) {
    for (int i = 0; i < numeroProductos.size(); i++) {
      actor.attemptsTo(
        WaitUntil.the(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
        Scroll.to(ART_PRODUCTO.of(numeroProductos.get(i))),
        WaitUntil.the(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
        WaitUntil.the(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i)), isCurrentlyVisible()).forNoMoreThan(20).seconds(),
        Click.on(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i))),
        Click.on(BTN_MODAL_AGREGAR)
      );
      int cantidad = randomGenerator.generarCantidades();
      for (int j = 0; j < cantidad - 1; j++) {
        actor.attemptsTo(
          WaitUntil.the(BTN_MODAL_AUMENTAR_CANTIDAD, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
          Click.on(BTN_MODAL_AUMENTAR_CANTIDAD));
      }
      String nombreProducto = Text.of(LBL_NOMBRE_PRODUCTO.of(numeroProductos.get(i))).answeredBy(actor);
      String precioProducto = Text.of(LBL_PRECIO_PRODUCTO.of(numeroProductos.get(i))).answeredBy(actor);
      actor.remember(nombreProducto, new DetalleProductoData(precioProducto, String.valueOf(cantidad)));
      actor.attemptsTo(Click.on(BTN_MODAL_CERRAR));
    }
    actor.remember("Numero de productos", numeroProductos.size());
  }

  public static Comprar deFormaRapida(List<String> numeroProductos) {
    return instrumented(Comprar.class, numeroProductos);
  }
}
