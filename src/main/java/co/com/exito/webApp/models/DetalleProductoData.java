package co.com.exito.webApp.models;

public class DetalleProductoData {

  private String precioProducto;
  private String cantidadProducto;

  public DetalleProductoData(String precioProducto, String cantidadProducto) {
    this.precioProducto = precioProducto;
    this.cantidadProducto = cantidadProducto;
  }

  public String getPrecioProducto() {
    return precioProducto;
  }

  public String getCantidadProducto() {
    return cantidadProducto;
  }
}
