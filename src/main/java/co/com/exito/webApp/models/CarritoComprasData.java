package co.com.exito.webApp.models;

public class CarritoComprasData {

  private String nombreProducto;
  private String precioXProducto;
  private String cantidadXProducto;

  private CarritoComprasData(String nombreProducto, String precioXProducto, String cantidadXProducto) {
    this.nombreProducto = nombreProducto;
    this.precioXProducto = precioXProducto;
    this.cantidadXProducto = cantidadXProducto;
  }

  public static CarritoComprasData crearNuevoProducto(String nombreProducto, String precioXProducto, String cantidadXProducto) {
    return new CarritoComprasData(nombreProducto, precioXProducto, cantidadXProducto);
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }

  public String getPrecioXProducto() {
    return precioXProducto;
  }

  public void setPrecioXProducto(String precioXProducto) {
    this.precioXProducto = precioXProducto;
  }

  public String getCantidadXProducto() {
    return cantidadXProducto;
  }

  public void setCantidadXProducto(String cantidadXProducto) {
    this.cantidadXProducto = cantidadXProducto;
  }
}
