package co.com.exito.webApp.exceptions;

public class CantidadNoDisponibleException extends AssertionError{

  public static final String CANTIDAD_NO_DISPONIBLE = "Las credenciales ya se encuentran registradas.";

  public CantidadNoDisponibleException(String mensaje, Throwable causa){
    super(mensaje, causa);
  }
}
