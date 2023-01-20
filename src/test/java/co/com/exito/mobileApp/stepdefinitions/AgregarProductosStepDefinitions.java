package co.com.exito.mobileApp.stepdefinitions;

import co.com.exito.mobileApp.models.AutenticacionUsuarioData;
import co.com.exito.mobileApp.models.TipoProductoData;
import co.com.exito.mobileApp.questions.ElNombreDelProducto;
import co.com.exito.mobileApp.tasks.Abrir;
import co.com.exito.mobileApp.tasks.Agregar;
import co.com.exito.mobileApp.tasks.Enviar;
import co.com.exito.mobileApp.tasks.RevisarProductos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductosStepDefinitions {

  @Dado("que el usuario se autentico con sus credenciales")
  public void queElUsuarioSeAutenticoConSusCredenciales(DataTable credenciales) {
    theActorInTheSpotlight().wasAbleTo(Abrir.ExitoApp());
    theActorInTheSpotlight().wasAbleTo(Enviar.lasCredenciales(AutenticacionUsuarioData.setData(credenciales).get(0)));
  }

  @Cuando("el agrega un producto al carro de compras")
  public void elAgregaUnProductoAlCarroDeCompras(DataTable filtros) {
    theActorInTheSpotlight().attemptsTo(Agregar.productoAlCarrito(TipoProductoData.setData(filtros).get(0)));
  }

  @Entonces("debe ver el producto en el carrito de compras")
  public void debeVerElProductoEnElCarritoDeCompras() {
    theActorInTheSpotlight().attemptsTo(RevisarProductos.enElCarrito());
    theActorInTheSpotlight().should(seeThat(ElNombreDelProducto.enElCarrito()));
  }
}
