package co.com.exito.webApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

  public static final Target BTN_MENU =
    Target.the("Botón menú hamburguesa")
      .located(By.id("category-menu"));

  public static final Target OPT_CATEGORIA =
    Target.the("Opción Categoría")
      .locatedBy("//p[text()='{0}']");

  public static final Target LNK_SUBCATEGORIA =
    Target.the("Opción Sub categoría")
      .locatedBy("//strong[text()='{0}']");

  public static final Target BTN_CARRITO =
    Target.the("Botón carrito de compras")
      .located(By.xpath("//a[@class = 'exito-header-3-x-minicartLink']"));
}
