package co.com.dummy.api.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.dummy.api.utils.RestService.CREATE_EMPLOYEE;

public class ConPost implements Interaction {

  private String bodyRequest;

  public ConPost(String bodyRequest) {
    this.bodyRequest = bodyRequest;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Post.to(CREATE_EMPLOYEE.toString())
      .with(requestSpecification -> requestSpecification
        .headers("Content-Type", "application/json")
        .body(bodyRequest)));
  }
}
