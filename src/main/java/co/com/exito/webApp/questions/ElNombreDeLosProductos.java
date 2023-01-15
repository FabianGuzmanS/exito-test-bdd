package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.CarritoComprasPage.LNK_NOMBRE_PRODUCTO;

public class ElNombreDeLosProductos implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler manejador = new ComprasHandler();
      List<CarritoComprasData> compras = manejador.getProductos();
      int aciertos = 0;
      for (int i = 0; i < compras.size(); i++) {
        String nombreProducto = Text.of(LNK_NOMBRE_PRODUCTO.of(String.valueOf(i + 1))).viewedBy(actor).asString();
        if (compras.get(i).getNombreProducto().equals(nombreProducto)) {
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

  public static ElNombreDeLosProductos enElCarrito() {
    return new ElNombreDeLosProductos();
  }
}
