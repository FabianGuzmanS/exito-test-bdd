#language:es
Característica: Crear nuevo empleado
  Yo como administrador
  Quiero poder crear nuevos empleados
  Para que se almacene un registro en la base de datos

  Esquema del escenario: : Crear un nuevo usuario
    Dado Fabian es el administrador de la pagina
    Cuando envia la informacion requerida
      | name   | salary   | age   |
      | <name> | <salary> | <age> |
    Entonces debe ver el empleado creado
    Ejemplos:
      | name  | salary | age |
      | test1 | 3000   | 23  |