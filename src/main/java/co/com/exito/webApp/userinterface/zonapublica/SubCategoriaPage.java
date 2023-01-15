package co.com.exito.webApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SubCategoriaPage {

  public static final Target LISTA_PRODUCTOS =
    Target.the("Lista de productos")
      .located(By.id("gallery-layout-container"));

  public static final Target LBL_NOMBRE_PRODUCTO =
    Target.the("Label nombre del producto")
      .locatedBy("(//span[@class = 'vtex-store-components-3-x-productBrand '])[{0}]");

  public static final Target LBL_PRECIO_PRODUCTO =
    Target.the("Label precio del producto")
      .locatedBy(
        "(//div[@class = 'exito-vtex-components-4-x-PricePDP']/span[@class = 'exito-vtex-components-4-x-currencyContainer'])[{0}]");

  public static final Target ART_PRODUCTO =
    Target.the("Articulo - producto")
      .locatedBy("(//div[@class = 'vtex-search-result-3-x-galleryItem vtex-search-result-3-x-galleryItem--normal vtex-search-result-3-x-galleryItem--default pa4'])[{0}]");

  public static final Target BTN_AGREGAR =
    Target.the("Botón Agregar producto al carro")
      .locatedBy("(//div[@class = 'exito-vtex-components-4-x-main'])[{0}]//span[text()='Agregar']");
      //.locatedBy("(//div[@class = 'exito-vtex-components-4-x-main'])[{0}]//span[@class = 'exito-vtex-components-4-x-buttonText']");

  public static final Target BTN_COMPRA_RAPIDA =
    Target.the("Botón compra rapida")
      .locatedBy("(//div[@class = 'exito-vtex-components-4-x-main'])[{0}]//span[text()='Compra rápida']");
      //.locatedBy("(//div[@class = 'exito-vtex-components-4-x-main'])[{0}]//span[@class = 'w-100 h-100']");

  public static final Target BTN_MODAL_AGREGAR =
    Target.the("Botón agregar producto desde el modal")
      .locatedBy("(//div[@class = 'exito-vtex-components-4-x-buttonDataContainer flex justify-center'])//span[text()='Agregar']");

  public static final Target POPUP_CANTIDAD_NO_DISPONIBLE =
    Target.the("PopUp cantidad de producto no disponible")
      .locatedBy("//div[@class = 'pr5 mw6-ns lh-copy' and contains(text(), 'No está disponible')]");
  public static final Target BTN_MODAL_AUMENTAR_CANTIDAD =
    Target.the("Botón aumentar cantidad desde el modal")
      .locatedBy("//button[@class = 'exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");

  public static final Target BTN_MODAL_CERRAR =
    Target.the("Botón cerrar modal")
      .locatedBy("//span[@class = 'exito-vtex-components-4-x-defaultModalClose']");

  public static final Target BTN_AUMENTAR_CANTIDAD =
    Target.the("Botón aumentar cantidad")
      .locatedBy(
        "(//div[@class = 'exito-vtex-components-4-x-main'])[{0}]//button[@class = 'exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");
}