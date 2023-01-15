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
import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.LBL_PRECIO_PRODUCTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Adicionar implements Interaction {

  private List<String> numeroProductos;

  public Adicionar(List<String> numeroProductos) {
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
          WaitUntil.the(BTN_AGREGAR.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
          Scroll.to(ART_PRODUCTO.of(numeroProductos.get(i))),
          WaitUntil.the(BTN_AGREGAR.of(numeroProductos.get(i)), isPresent()).forNoMoreThan(20).seconds(),
          Click.on(BTN_AGREGAR.of(numeroProductos.get(i))));
        cantidad = randomGenerator.generarCantidades();
        for (int j = 0; j < cantidad - 1; j++) {
          actor.should(seeThat(the(POPUP_CANTIDAD_NO_DISPONIBLE), isNotPresent())
            .orComplainWith(CantidadNoDisponibleException.class, CANTIDAD_NO_DISPONIBLE));
          actor.attemptsTo(
            WaitUntil.the(BTN_AUMENTAR_CANTIDAD.of(numeroProductos.get(i)), isCurrentlyVisible()).forNoMoreThan(20).seconds(),
            Click.on(BTN_AUMENTAR_CANTIDAD.of(numeroProductos.get(i)))
          );
        }
        String nombreProducto = Text.of(LBL_NOMBRE_PRODUCTO.of(numeroProductos.get(i))).viewedBy(actor).asString();
        String precioProducto = Text.of(LBL_PRECIO_PRODUCTO.of(numeroProductos.get(i))).viewedBy(actor).asString();
        carritoComprasData = CarritoComprasData.crearNuevoProducto(nombreProducto, precioProducto, String.valueOf(cantidad));
        comprasHandler.AgregarProductoLista(carritoComprasData);
      }
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
  }

  public static Adicionar deFormaMasiva(List<String> numeroProductos) {
    return instrumented(Adicionar.class, numeroProductos);
  }
}
