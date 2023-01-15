package co.com.exito.webApp.runners.zonapublica;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/zonapublica/agregar_productos.feature",
  glue = "co.com.exito.webApp.stepdefinitions",
  snippets = SnippetType.CAMELCASE)
public class AgregarProductosRunner {
}
