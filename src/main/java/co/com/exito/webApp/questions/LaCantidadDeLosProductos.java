package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.CarritoComprasPage.TXT_CANTIDAD_PRODUCTO;

public class LaCantidadDeLosProductos implements Question<Boolean> {

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler comprasHandler = new ComprasHandler();
      List<CarritoComprasData> compras = comprasHandler.getProductos();

      int aciertos = 0;
      for (int i = 0; i < compras.size(); i++) {
        String cantidadProducto = Value.of(TXT_CANTIDAD_PRODUCTO.of(String.valueOf(i + 1))).viewedBy(actor).asString();
        if (compras.get(i).getCantidadXProducto().equals(cantidadProducto)) {
          aciertos = aciertos + 1;
        }
      }
      if (aciertos == compras.size()) {
        resultado = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      Serenity.getWebdriverManager().getCurrentDriver().quit();
    }
    return resultado;
  }

  public static LaCantidadDeLosProductos enElCarrito() {
    return new LaCantidadDeLosProductos();
  }
}
