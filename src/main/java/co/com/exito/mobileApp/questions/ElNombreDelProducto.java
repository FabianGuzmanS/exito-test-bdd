package co.com.exito.mobileApp.questions;

import co.com.exito.mobileApp.utils.ComprasHandler;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.exito.mobileApp.userinterface.zonapublica.CarritoPage.LBL_NOMBRE_PRODUCTO_CARRITO;

public class ElNombreDelProducto implements Question<Boolean> {
  ComprasHandler comprasHandler = new ComprasHandler();

  @Override
  @Subject("visualiza el nombre del producto")
  public Boolean answeredBy(Actor actor) {
    return Text.of(LBL_NOMBRE_PRODUCTO_CARRITO.of(comprasHandler.getProductos())).answeredBy(actor).equals(comprasHandler.getProductos());
  }

  public static ElNombreDelProducto enElCarrito(){
    return new ElNombreDelProducto();
  }
}
