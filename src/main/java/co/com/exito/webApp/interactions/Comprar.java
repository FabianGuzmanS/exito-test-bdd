package co.com.exito.webApp.interactions;

import co.com.exito.webApp.exceptions.CantidadNoDisponibleException;
import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import co.com.exito.webApp.utils.Transversal.RandomGenerator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.exito.webApp.exceptions.CantidadNoDisponibleException.CANTIDAD_NO_DISPONIBLE;
import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Comprar implements Interaction {

  private List<String> numeroProductos;

  public Comprar(List<String> numeroProductos) {
    this.numeroProductos = numeroProductos;
  }

  RandomGenerator randomGenerator = new RandomGenerator();
  ComprasHandler comprasHandler = new ComprasHandler();
  CarritoComprasData carritoComprasData;

  int cantidad;

  @Override
  public <T extends Actor> void performAs(T actor) {
    try {
      for (int i = 0; i < numeroProductos.size(); i++) {
        actor.attemptsTo(
          WaitUntil.the(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
          Scroll.to(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i))),
          Click.on(BTN_COMPRA_RAPIDA.of(numeroProductos.get(i))),
          Click.on(BTN_MODAL_AGREGAR)
        );
        cantidad = randomGenerator.generarCantidades();
        for (int j = 0; j < cantidad - 1; j++) {
          actor.should(seeThat(the(POPUP_CANTIDAD_NO_DISPONIBLE), isNotPresent())
            .orComplainWith(CantidadNoDisponibleException.class, CANTIDAD_NO_DISPONIBLE));
          actor.attemptsTo(Click.on(BTN_MODAL_AUMENTAR_CANTIDAD));
        }
        String nombreProducto = Text.of(LBL_NOMBRE_PRODUCTO.of(numeroProductos.get(i))).viewedBy(actor).asString();
        String precioProducto = Text.of(LBL_PRECIO_PRODUCTO.of(numeroProductos.get(i))).viewedBy(actor).asString();
        carritoComprasData = CarritoComprasData.crearNuevoProducto(nombreProducto, precioProducto, String.valueOf(cantidad));
        comprasHandler.AgregarProductoLista(carritoComprasData);
        actor.attemptsTo(Click.on(BTN_MODAL_CERRAR));
      }
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static Comprar deFormaRapida(List<String> numeroProductos) {
    return instrumented(Comprar.class, numeroProductos);
  }
}
