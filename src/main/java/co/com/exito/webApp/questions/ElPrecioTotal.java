package co.com.exito.webApp.questions;

import co.com.exito.webApp.models.CarritoComprasData;
import co.com.exito.webApp.utils.Transversal.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.exito.webApp.userinterface.zonapublica.CarritoComprasPage.LBL_PRECIO_TOTAL_PRODUCTO;

public class ElPrecioTotal implements Question<Boolean> {

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado = false;
    try {
      ComprasHandler comprasHandler = new ComprasHandler();
      List<CarritoComprasData> compras = comprasHandler.getProductos();
      String precioUnitario = "";
      int aciertos = 0;
      for (int i = 0; i < compras.size(); i++) {
        String precioTotalXProducto = Text.of(LBL_PRECIO_TOTAL_PRODUCTO.of(String.valueOf(i + 1))).viewedBy(actor).asString();
        precioUnitario = comprasHandler.valorUnidadProducto(precioTotalXProducto, compras.get(i).getCantidadXProducto());
        if (compras.get(i).getPrecioXProducto().equals(precioUnitario)) {
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

  public static ElPrecioTotal porProducto() {
    return new ElPrecioTotal();
  }
}