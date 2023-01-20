#language:es
Característica: Autenticarse en la App Éxito
  Yo como usuario
  Quiero autenticarme en la app
  Para tener acceso a mi cuenta

  Esquema del escenario: : Autenticacion exitosa
    Dado el usuario ingreso a la aplicación
    Cuando envia la información requerida
      | correo   | password   |
      | <correo> | <password> |
    Entonces debe ver el perfil de usuario cargado
      | nombres   |
      | <nombres> |
    Ejemplos:
      | correo                   | password  | nombres       |
      | fabianPrueba@yopmail.com | Prueba123 | Pedro Gabriel |