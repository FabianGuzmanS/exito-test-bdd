package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

import java.util.List;

public class ElNumeroDeProductos implements Question<Boolean> {

  private int numeroProductos;

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler manejador = new ComprasHandler();
      List<CarritoComprasData> compras = manejador.getProductos();
      numeroProductos = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//tr[@class='product-item']")).size();
      if (compras.size() == numeroProductos) {
        resultado = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
    return resultado;
  }

  public static ElNumeroDeProductos agregadosEnElCarritoDeCompras() {
    return new ElNumeroDeProductos();
  }
}
