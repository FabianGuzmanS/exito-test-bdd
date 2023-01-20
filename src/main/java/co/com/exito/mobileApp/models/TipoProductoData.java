package co.com.exito.mobileApp.models;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TipoProductoData {

  private String categoria;
  private String subCategoria;

  public TipoProductoData(String categoria, String subCategoria) {
    this.categoria = categoria;
    this.subCategoria = subCategoria;
  }

  public String getCategoria() {
    return categoria;
  }

  public String getSubCategoria() {
    return subCategoria;
  }


  public static List<TipoProductoData> setData(DataTable data) {
    List<TipoProductoData> tipoProducto = new ArrayList<>();
    List<Map<String,String>> filas = data.asMaps(String.class, String.class);
    for (Map<String, String> columnas: filas){
      tipoProducto.add(new TipoProductoData(columnas.get("categoria"), columnas.get("subCategoria")));
    }
    return tipoProducto;
  }
}