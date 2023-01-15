package co.com.dummy.api.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.dummy.api.utils.RestService.GET_EMPLOYEES;

public class ConGet implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Get.resource(GET_EMPLOYEES.toString())
      .with(requestSpecification -> requestSpecification
        .headers("Content-Type", "application/json")));
  }
}
