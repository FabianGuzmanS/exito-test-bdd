package co.com.exito.mobileApp.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/autenticarse.feature",
  glue = "co.com.exito.mobileApp.stepdefinitions",
  snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AutenticarseRunner {
}
