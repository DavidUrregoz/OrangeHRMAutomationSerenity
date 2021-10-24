# new feature
# Tags: optional

Feature: Como Empleado administrativo
  necesito filtrar la información de los empleados en la plataforma de  orangeHRM
  con el fin de reducir el tiempo de búsqueda y aumentar la efectividad.


  Scenario: busqueda por nombre de empleado.
    Given que el empleado administrativo se encuentra correctamente autenticado en la aplicacion de orangeHRM
    When el empleado proceda a hacer una busqueda en la sesion de Admin  por medio del Employee name
    Then el sistema debe retornar una lista con la informacion filtrada.