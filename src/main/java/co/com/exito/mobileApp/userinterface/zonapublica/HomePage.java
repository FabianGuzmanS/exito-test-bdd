package co.com.exito.mobileApp.userinterface.zonapublica;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

  public static final Target LBL_NOMBRE_USUARIO =
    Target.the("Label nombre de usuario")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/textView_user_name']");

  public static final Target BTN_COMPRAS =
    Target.the("Botón compras")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/third_item']");

  public static final Target OPT_COMPRA_RECOGE =
    Target.the("Opción comprar y recoger")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/constraitLayout_buy_and_collect']");

  public static final Target DDL_CIUDAD =
    Target.the("Lista ciudades")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/filled_exposed_dropdown_city']");

  public static final Target DDLOPT_CIUDAD =
    Target.the("Opción ciudad")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/txtDropDownLabel' and @text ='{0}']");

  public static final Target DDL_ALMACEN =
    Target.the("Lista almacenes")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/filled_exposed_dropdown_store']");

  public static final Target DDLOPT_ALMACEN =
    Target.the("Opción almacen")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/txtDropDownLabel' and @text='{0}']");

  public static final Target BTN_CONTINUAR =
    Target.the("Botón continuar")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/appCompatButton_continue']");

  public static final Target POPUP_INFO_ACTUALIZADA =
    Target.the("PopUp info actualizada")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/tv_message']");

  public static final Target OPT_CATEGORIA =
    Target.the("Opción categoria")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/textView_department' and @text='{0}']");

  public static final Target OPT_SUBCATEGORIA =
    Target.the("Opción subcategoria")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/textView_department_category' and @text='{0}']");

  public static final Target LBL_NOMBRE_PRODUCTO =
    Target.the("Label nombre producto")
      .locatedBy("(//*[@resource-id='com.exito.appcompania:id/appCompatTextView_product_title'])[1]");

  public static final Target BTN_AGREGAR =
    Target.the("Botón agregar")
      .locatedBy("(//*[@resource-id='com.exito.appcompania:id/constraitLayout_add_item'])[1]");

  public static final Target BTN_AUMENTAR_CANTIDAD =
    Target.the("Botón aumentar cantidad")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/appCompatImageView_add_item']");

  public static final Target BTN_CARRITO_COMPRAS =
    Target.the("Botón carrito compras")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/appCompatImageView_shopping_cart']");

  public static final Target BTN_MI_CUENTA =
    Target.the("Botón mi cuenta")
      .locatedBy("//*[@resource-id='com.exito.appcompania:id/fifth_item']");

}
