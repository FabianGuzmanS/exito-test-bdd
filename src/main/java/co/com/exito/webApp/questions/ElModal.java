package co.com.exito.webApp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.exito.webApp.userinterface.zonapublica.SubCategoriaPage.MODAL_LOCALIZACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ElModal implements Question<Boolean> {
  @Override
  @Subject("visualiza el modal de localización")
  public Boolean answeredBy(Actor actor) {
    boolean visibilidad = false;
    try {
      WaitUntil.the(MODAL_LOCALIZACION, isCurrentlyVisible()).forNoMoreThan(30).seconds();
      visibilidad = Visibility.of(MODAL_LOCALIZACION).viewedBy(actor).asBoolean();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return visibilidad;
  }

  public static ElModal deLocalizacionEsVisible() {
    return new ElModal();
  }
}
