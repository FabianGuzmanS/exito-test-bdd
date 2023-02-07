package co.com.dummy.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/editar_empleado.feature",
  glue = "co.com.dummy.api.stepdefinitions",
  snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class EditarEmpleadoRunner {
}
