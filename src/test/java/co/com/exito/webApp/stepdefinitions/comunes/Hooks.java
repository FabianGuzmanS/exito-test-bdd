package co.com.exito.webApp.stepdefinitions.comunes;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;

import static co.com.exito.webApp.utils.constantes.Constantes.ACTOR;

public class Hooks {
  @BeforeAll
  public static void setUpBrowser() {
    switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        break;
      case "ie":
      case "iexplorer":
        WebDriverManager.iedriver().setup();
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        break;
      default:
        WebDriverManager.chromedriver().setup();
        break;
    }
  }

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled(ACTOR);
  }

  @After
  public void after() {
    Serenity.getWebdriverManager().getCurrentDriver().quit();
  }
}
