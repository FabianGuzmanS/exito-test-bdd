package co.com.dummy.api.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicio {

  public static ConPost conPost(String bodyRequest){
    return instrumented(ConPost.class, bodyRequest);
  }

  public static ConGet conGet(){
    return instrumented(ConGet.class);
  }

  public static ConPut conPut(String bodyRequest, String pathParams){
    return instrumented(ConPut.class, bodyRequest, pathParams);
  }

  public static ConDelete conDelete(String idPathParam){
    return instrumented(ConDelete.class, idPathParam);
  }
}
