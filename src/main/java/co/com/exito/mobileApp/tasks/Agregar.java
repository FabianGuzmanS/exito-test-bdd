package co.com.exito.mobileApp.tasks;

import co.com.exito.mobileApp.interactions.FiltrarTipoProducto;
import co.com.exito.mobileApp.models.TipoProductoData;
import co.com.exito.mobileApp.utils.ComprasHandler;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Agregar implements Task {

  private TipoProductoData tipoProducto;

  public Agregar(TipoProductoData tipoProducto) {
    this.tipoProducto = tipoProducto;
  }

  SoftAssertions softAssertions = new SoftAssertions();
  static final Logger logger = LoggerFactory.getLogger(Agregar.class);

  @Override
  @Step("{0} agrega productos al carrito")
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(
        FiltrarTipoProducto.porSubCategoria(tipoProducto.getCategoria(), tipoProducto.getSubCategoria()),
        Click.on(BTN_AGREGAR),
        Click.on(BTN_AUMENTAR_CANTIDAD)
      );
      String producto = Text.of(LBL_NOMBRE_PRODUCTO).answeredBy(actor);
      ComprasHandler comprasHandler = new ComprasHandler();
      comprasHandler.AgregarProductoLista(producto);
    } catch (Exception e) {
      logger.info("¡OCURRIO UN ERROR!");
      Serenity.getWebdriverManager().getCurrentDriver().quit();
      softAssertions.fail(e.getMessage());
      softAssertions.assertAll();
    }
  }

  public static Agregar productoAlCarrito(TipoProductoData tipoProducto) {
    return instrumented(Agregar.class, tipoProducto);
  }
}
