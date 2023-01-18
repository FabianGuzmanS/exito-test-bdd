package co.com.exito.webApp.stepdefinitions.zonapublica;

import co.com.exito.webApp.exceptions.CantidadNoDisponibleException;
import co.com.exito.webApp.exceptions.ListaDeProductosAlteradaException;
import co.com.exito.webApp.models.TipoProductoData;
import co.com.exito.webApp.questions.ElNombreDeLosProductos;
import co.com.exito.webApp.questions.ElNumeroDeProductos;
import co.com.exito.webApp.questions.ElPrecioTotal;
import co.com.exito.webApp.questions.LaCantidadDeLosProductos;
import co.com.exito.webApp.tasks.zonapublica.Abrir;
import co.com.exito.webApp.tasks.zonapublica.Agregar;
import co.com.exito.webApp.tasks.zonapublica.RevisarProductos;
import co.com.exito.webApp.tasks.zonapublica.Seleccionar;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.exito.webApp.exceptions.CantidadNoDisponibleException.CANTIDAD_NO_DISPONIBLE;
import static co.com.exito.webApp.exceptions.ListaDeProductosAlteradaException.LISTA_PRODUCTOS_ALTERADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AgregarProductosStepDefinitions {

  @Dado("^el usuario quiere comprar productos en Tiendas Exito web$")
  public void elUsuarioQuiereComprarProductosEnTiendasExitoWeb() {
    theActorInTheSpotlight().wasAbleTo(Abrir.laPagina());
  }

  @Cuando("^el agrega productos al carrito de compras$")
  public void elAgregaProductosAlCarritoDeCompras(DataTable dataTable) {
    theActorInTheSpotlight().attemptsTo(Seleccionar.unaSubcategoria(TipoProductoData.setData(dataTable).get(0)));
    theActorInTheSpotlight().attemptsTo(Agregar.productosAlCarrito(TipoProductoData.setData(dataTable).get(0)));
  }

  @Entonces("^debera ver en el carrito, los productos agregados$")
  public void deberaVerEnElCarritoLosProductosAgregados() {
    theActorInTheSpotlight().attemptsTo(RevisarProductos.enElCarrito());
    theActorInTheSpotlight().should(seeThat(ElNumeroDeProductos.agregadosEnElCarritoDeCompras())
      .orComplainWith(ListaDeProductosAlteradaException.class, LISTA_PRODUCTOS_ALTERADA));
  }

  @Y("^ver el mismo nombre de los productos agregados, en el carrito de compras$")
  public void verElMismoNombreDeLosProductosAgregadosEnElCarritoDeCompras() {
    theActorInTheSpotlight().should(seeThat(ElNombreDeLosProductos.enElCarrito()));
  }

  @Y("^ver el precio total de los productos agregados$")
  public void verElPrecioTotalDeLosProductosAgregados() {
    theActorInTheSpotlight().should(seeThat(ElPrecioTotal.porProducto()));
  }

  @Y("^ver la cantidad de cada producto de acuerdo a lo agregado$")
  public void verLaCantidadDeCadaProductoDeAcuerdoALoAgregado() {
    theActorInTheSpotlight().should(seeThat(LaCantidadDeLosProductos.enElCarrito())
      .orComplainWith(CantidadNoDisponibleException.class, CANTIDAD_NO_DISPONIBLE));
  }
}
