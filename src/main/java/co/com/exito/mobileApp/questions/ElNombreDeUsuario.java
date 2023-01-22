package co.com.exito.mobileApp.questions;

import co.com.exito.mobileApp.models.PerfilUsuarioData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.exito.mobileApp.userinterface.zonapublica.HomePage.LBL_NOMBRE_USUARIO;

public class ElNombreDeUsuario implements Question<Boolean> {
  private PerfilUsuarioData perfil;

  public ElNombreDeUsuario(PerfilUsuarioData perfil) {
    this.perfil = perfil;
  }

  @Override
  @Subject("visualiza el nombre de usuario")
  public Boolean answeredBy(Actor actor) {
    return Text.of(LBL_NOMBRE_USUARIO).answeredBy(actor).contains(perfil.getNombres());
  }

  public static ElNombreDeUsuario enLaPaginaDeInicio(PerfilUsuarioData perfil){
    return new ElNombreDeUsuario(perfil);
  }
}
