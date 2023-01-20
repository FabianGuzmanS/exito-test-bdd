package co.com.exito.mobileApp.utils;

import java.util.ArrayList;
import java.util.List;

public class ComprasHandler {

  private static final List<String> productos = new ArrayList<>();

  public void AgregarProductoLista(String producto) {
    productos.add(producto);
  }

  public String getProductos() {
    return productos.get(0);
  }

  public void limpiarLista(){
    productos.clear();
  }
}
