package co.com.dummy.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElCodigoRespuesta implements Question<Integer> {

  @Override
  public Integer answeredBy(Actor actor) {
    return SerenityRest.lastResponse().statusCode();
  }

  public static ElCodigoRespuesta es(){
    return new ElCodigoRespuesta();
  }
}
