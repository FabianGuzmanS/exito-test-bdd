package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.interactions.Ubicacion;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Seleccionar {

  public static Ubicacion ubicacacionDeRecogidaDeCompra(){
    return instrumented(Ubicacion.class);
  }
}
