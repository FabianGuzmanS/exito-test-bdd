package co.com.exito.webApp.utils.Transversal;

import java.text.NumberFormat;

public class ComprasHandler {

  public String valorTotalXProducto(String valorUnitario, int cantidad) {
    String resultado;
    int precioTotal = limpiarPrecio(valorUnitario);
    int total = precioTotal*cantidad;
    NumberFormat formato = NumberFormat.getInstance();
    formato.setGroupingUsed(true);
    String numeroFormateado = formato.format(total);
    numeroFormateado = numeroFormateado.replace(",",".");
    resultado = "$ " + numeroFormateado;
    return resultado;
  }

  public int limpiarPrecio(String precio) {
    int precioLimpio;
    precio = precio.replace("$ ", "").replace(".", "");
    precioLimpio = Integer.parseInt(precio);
    return precioLimpio;
  }
}
