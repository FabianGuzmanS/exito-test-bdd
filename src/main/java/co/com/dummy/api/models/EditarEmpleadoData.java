package co.com.dummy.api.models;

public class EditarEmpleadoData {
  private String id;
  private String name;
  private String salary;
  private String age;

  public EditarEmpleadoData(String id, String name, String salary, String age) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "{" +
      "name='" + name + '\'' +
      ", salary='" + salary + '\'' +
      ", age='" + age + '\'' +
      '}';
  }
}
