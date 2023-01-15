#language:es
Característica: Eliminar empleado
  Yo como administrador
  Quiero poder eliminar empleados
  Para tener almacenados unicamente los empleados activos

  Esquema del escenario: Eliminar empleados
    Dado Fabian es el administrador de la pagina
    Cuando envia la solicitud de eliminación de usuario
      | id   |
      | <id> |
    Entonces deberia obtener un resultado exitoso
    Ejemplos:
      | id |
      | 1  |