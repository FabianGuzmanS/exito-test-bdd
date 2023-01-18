package co.com.exito.webApp.exceptions;

public class ListaDeProductosAlteradaException extends AssertionError {
  public static final String LISTA_PRODUCTOS_ALTERADA = "La lista de productos en el carrito se altero (Eliminaron o agregaron productos).";

  public ListaDeProductosAlteradaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
