package co.com.exito.webApp.utils.Transversal;

import co.com.exito.webApp.models.CarritoComprasData;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ComprasHandler {

  private static final List<CarritoComprasData> productos = new ArrayList<>();

  public void AgregarProductoLista(CarritoComprasData producto) {
    productos.add(producto);
  }

  public List<CarritoComprasData> getProductos() {
    return productos;
  }

  public String valorUnidadProducto(String valorTotalProducto, String cantidad) {
    String resultado;
    int precioTotal = limpiarPrecio(valorTotalProducto);
    int cant = Integer.parseInt(cantidad);
    int total = precioTotal/cant;
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

  public void limpiarLista(){
    productos.clear();
  }
}
