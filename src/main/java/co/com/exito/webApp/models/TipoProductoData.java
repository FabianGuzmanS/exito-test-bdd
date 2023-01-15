package co.com.exito.webApp.models;

import cucumber.api.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TipoProductoData {

  private String categoria;
  private String subCategoria;
  private String numeroProductos;

  public TipoProductoData(String categoria, String subCategoria, String numeroProductos) {
    this.categoria = categoria;
    this.subCategoria = subCategoria;
    this.numeroProductos = numeroProductos;
  }

  public String getCategoria() {
    return categoria;
  }

  public String getSubCategoria() {
    return subCategoria;
  }

  public String getNumeroProductos() {
    return numeroProductos;
  }

  public static List<TipoProductoData> setData(DataTable data) {
    List<TipoProductoData> tipoProducto = new ArrayList<>();
    List<Map<String,String>> filas = data.asMaps(String.class, String.class);
    for (Map<String, String> columnas: filas){
      tipoProducto.add(new TipoProductoData(columnas.get("categoria"), columnas.get("subCategoria"), columnas.get("numeroProductos")));
    }
    return tipoProducto;
  }
}
