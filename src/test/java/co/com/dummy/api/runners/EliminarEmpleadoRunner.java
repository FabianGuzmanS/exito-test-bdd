package co.com.dummy.api.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/eliminar_empleado.feature",
  glue = "co.com.dummy.api.stepdefinitions",
  snippets = SnippetType.CAMELCASE)
public class EliminarEmpleadoRunner {
}
