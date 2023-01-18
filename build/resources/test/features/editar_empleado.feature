#language:es
Característica: Editar datos de empleados
  Yo como administrador
  Quiero poder editar los datos de los empleados
  Para tener almacenada información actualizada

  Esquema del escenario: Editar todos los datos de un empleado
    Dado Fabian es el administrador de la pagina
    Cuando envia la información editada del usuario
      | id   | name   | salary   | age   |
      | <id> | <name> | <salary> | <age> |
    Entonces deberia ver la información actualizada
    Ejemplos:
      | id | name        | salary | age |
      | 1  | Tiger Nixon | 400000 | 62  |