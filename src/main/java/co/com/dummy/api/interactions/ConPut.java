package co.com.dummy.api.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.dummy.api.utils.RestService.UPDATE_EMPLOYEE;

public class ConPut implements Interaction {

  private String bodyRequest;
  private String pathParams;

  public ConPut(String bodyRequest, String pathParams) {
    this.bodyRequest = bodyRequest;
    this.pathParams = pathParams;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Put.to(UPDATE_EMPLOYEE.toString())
      .with(requestSpecification -> requestSpecification
        .headers("Content-Type", "application/json")
        .pathParam("id", pathParams)
        .body(bodyRequest)));
  }
}
