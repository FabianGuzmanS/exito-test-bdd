package co.com.dummy.api.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.dummy.api.utils.RestService.DELETE_EMPLOYEE;

public class ConDelete implements Interaction {

  private String idPathParam;

  public ConDelete(String idPathParam) {
    this.idPathParam = idPathParam;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Delete.from(DELETE_EMPLOYEE.toString())
      .with(requestSpecification -> requestSpecification
        .headers("Content-Type", "application/json")
        .pathParam("id", idPathParam)));
  }
}
