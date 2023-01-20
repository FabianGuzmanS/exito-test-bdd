package co.com.exito.mobileApp.models;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerfilUsuarioData {
  private String nombres;

  public PerfilUsuarioData(String nombres) {
    this.nombres = nombres;
  }

  public String getNombres() {
    return nombres;
  }

  public static List<PerfilUsuarioData> setData(DataTable data) {
    List<PerfilUsuarioData> perfilUsuario = new ArrayList<>();
    List<Map<String,String>> filas = data.asMaps(String.class, String.class);
    for (Map<String, String> columnas: filas){
      perfilUsuario.add(new PerfilUsuarioData(columnas.get("nombres")));
    }
    return perfilUsuario;
  }
}
