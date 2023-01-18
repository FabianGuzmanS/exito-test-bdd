package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ElNumeroDeProductos implements Question<Boolean> {
  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(ElNumeroDeProductos.class);
  @Override
  @Subject("visualiza los productos agregados, en el carrito")
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler manejador = new ComprasHandler();
      List<CarritoComprasData> compras = manejador.getProductos();
      int numeroProductos = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//tr[@class='product-item']")).size();
      if (compras.size() == numeroProductos) {
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

  public static ElNumeroDeProductos agregadosEnElCarritoDeCompras() {
    return new ElNumeroDeProductos();
  }
}
