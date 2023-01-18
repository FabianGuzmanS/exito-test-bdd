package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static co.com.exito.webApp.userinterface.zonapublica.CarritoComprasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class LaCantidadDeLosProductos implements Question<Boolean> {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(ElNombreDeLosProductos.class);

  @Override
  @Subject("visualiza la cantidad por producto, en el carrito")
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler comprasHandler = new ComprasHandler();
      List<CarritoComprasData> compras = comprasHandler.getProductos();
      AtomicInteger aciertos = new AtomicInteger();
      actor.attemptsTo(Scroll.to(FILA_PRODUCTO.of("1")));
      for (int i = 0; i < compras.size(); i++) {
        actor.attemptsTo(
          WaitUntil.the(LNK_NOMBRE_PRODUCTO.of(String.valueOf(i + 1)), isCurrentlyVisible()).forNoMoreThan(20).seconds(),
          WaitUntil.the(TXT_CANTIDAD_PRODUCTO.of(String.valueOf(i + 1)), isCurrentlyVisible()).forNoMoreThan(20).seconds()
        );
        String nombreProducto = Text.of(LNK_NOMBRE_PRODUCTO.of(String.valueOf(i + 1))).viewedBy(actor).asString();
        String cantidadProducto = Value.of(TXT_CANTIDAD_PRODUCTO.of(String.valueOf(i + 1))).viewedBy(actor).asString();
        compras.stream()
          .filter(compra -> nombreProducto.contains(compra.getNombreProducto()))
          .forEach(compra -> {
            if (compra.getCantidadXProducto().equals(cantidadProducto)) {
              aciertos.getAndIncrement();
            }
          });
        if (i + 1 < compras.size()) {
          actor.attemptsTo(Scroll.to(FILA_PRODUCTO.of(String.valueOf(i + 2))));
        }
      }
      if (aciertos.get() == compras.size()) {
        resultado = true;
      }
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
    return resultado;
  }

  public static LaCantidadDeLosProductos enElCarrito() {
    return new LaCantidadDeLosProductos();
  }
}
