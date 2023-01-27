package co.com.exito.webApp.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.By;

public class ElNumeroDeProductos implements Question<Boolean> {
  @Override
  @Subject("visualiza los productos agregados, en el carrito")
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    int numeroProductosAgregados = actor.recall("Numero de productos");
    int numeroProductos = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//tr[@class='product-item']")).size();
    if (numeroProductosAgregados == numeroProductos) {
      resultado = true;
    }
    return resultado;
  }

  public static ElNumeroDeProductos agregadosEnElCarritoDeCompras() {
    return new ElNumeroDeProductos();
  }
}
