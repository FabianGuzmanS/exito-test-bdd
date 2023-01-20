package co.com.exito.mobileApp.models;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutenticacionUsuarioData {

  private String correo;
  private String password;

  public AutenticacionUsuarioData(String correo, String password) {
    this.correo = correo;
    this.password = password;
  }

  public String getCorreo() {
    return correo;
  }

  public String getPassword() {
    return password;
  }

  public static List<AutenticacionUsuarioData> setData(DataTable data) {
    List<AutenticacionUsuarioData> credencialesData = new ArrayList<>();
    List<Map<String,String>> filas = data.asMaps(String.class, String.class);
    for (Map<String, String> columnas: filas){
      credencialesData.add(new AutenticacionUsuarioData(
        columnas.get("correo"),
        columnas.get("password")));
    }
    return credencialesData;
  }
}
