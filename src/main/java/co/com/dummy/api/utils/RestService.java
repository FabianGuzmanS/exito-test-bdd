package co.com.dummy.api.utils;

public enum RestService {

  BASE_URL("https://dummy.restapiexample.com/api/v1"),
  CREATE_EMPLOYEE("/create"),
  GET_EMPLOYEES("/employees"),
  UPDATE_EMPLOYEE("/update/{id}"),
  DELETE_EMPLOYEE("/delete/{id}");

  private String uri;

  RestService(String uri){
    this.uri = uri;
  }

  @Override
  public String toString(){
    return uri;
  }
}
