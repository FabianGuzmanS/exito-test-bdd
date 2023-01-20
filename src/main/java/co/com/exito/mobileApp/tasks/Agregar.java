package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.models.TipoProductoData;
import co.com.exito.mobileApp.utils.ComprasHandler;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Agregar implements Task {

  private TipoProductoData tipoProducto;

  public Agregar(TipoProductoData tipoProducto) {
    this.tipoProducto = tipoProducto;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
      Click.on(BTN_COMPRAS),
      Click.on(OPT_COMPRA_RECOGE),
      Enter.theValue("Bogotá, D.c.").into(DDL_CIUDAD),
      Click.on(DDL_ALMACEN),
      Enter.theValue("EXITO Calle 80").into(DDL_ALMACEN),
      Click.on(BTN_CONTINUAR),
      Click.on(BTN_CONTINUAR),
      Click.on(OPT_CATEGORIA.of(tipoProducto.getCategoria())),
      Click.on(OPT_SUBCATEGORIA.of(tipoProducto.getSubCategoria())),
      Click.on(BTN_AGREGAR),
      Click.on(BTN_AUMENTAR_CANTIDAD)
    );
    String producto = Text.of(LBL_NOMBRE_PRODUCTO).answeredBy(actor).toString();
    ComprasHandler comprasHandler = new ComprasHandler();
    comprasHandler.AgregarProductoLista(producto);
  }

  public static Agregar productoAlCarrito(TipoProductoData tipoProducto){
    return instrumented(Agregar.class, tipoProducto);
  }
}
