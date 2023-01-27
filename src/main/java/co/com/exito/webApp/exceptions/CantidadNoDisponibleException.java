package co.com.exito.webApp.exceptions;

public class CantidadNoDisponibleException extends AssertionError{

  public static final String CANTIDAD_NO_DISPONIBLE = "La cantidad seleccionada no esta disponible y se actualiza con la cantidad disponible.";

  public CantidadNoDisponibleException(String mensaje, Throwable causa){
    super(mensaje, causa);
  }
}
