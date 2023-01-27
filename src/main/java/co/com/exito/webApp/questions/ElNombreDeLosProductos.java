package co.com.exito.webApp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static co.com.exito.webApp.userinterface.zonapublica.CarritoComprasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ElNombreDeLosProductos implements Question<Boolean> {
  @Override
  @Subject("visualiza el nombre de los productos en el carrito")
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    AtomicInteger aciertos = new AtomicInteger();
    int numeroProductos = actor.recall("Numero de productos");
    Map<String, Object> actorNotepad = actor.recallAll();
    for (int i = 0; i < numeroProductos; i++) {
      actor.attemptsTo(
        WaitUntil.the(LNK_NOMBRE_PRODUCTO.of(String.valueOf(i + 1)), isCurrentlyVisible()).forNoMoreThan(20).seconds()
      );
      String nombreProducto = Text.of(LNK_NOMBRE_PRODUCTO.of(String.valueOf(i + 1))).answeredBy(actor);
      actorNotepad.entrySet().stream()
        .filter(entrada -> nombreProducto.contains(entrada.getKey()))
        .forEach(entrada -> aciertos.getAndIncrement());
      if (i + 1 < numeroProductos) {
        actor.attemptsTo(Scroll.to(FILA_PRODUCTO.of(String.valueOf(i + 2))));
      }
    }
    if (aciertos.get() == numeroProductos) {
      resultado = true;
    }
    return resultado;
  }

  public static ElNombreDeLosProductos enElCarrito() {
    return new ElNombreDeLosProductos();
  }
}
