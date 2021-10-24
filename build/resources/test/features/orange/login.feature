Feature: Como Empleado admistrativo
  necesito autenticarme en la plataforma de OrangeHRM
  con el fin gestionar y los datos de usuarios allí alojados.

  Background:
    Given que el empleado administrativo se encuentra en la pagina web de OrangeHRM  en el formulario de inicio login

  Scenario: Login exitoso
    When el empleado administrativo ingresa un User y Password correctos y presiona el boton de login
    Then el sistema debera ingresar exitosamente a la pagina de index.php/dashboard

  Scenario: Login fallido por datos invalidos
    When el empleado administrativo ingresa un User y Password incorrectos y presiona el boton de login
    Then el sistema debera retornar un mensaje en pantalla Invalid credentials

  Scenario: Login fallido falta de campo user
    When el empleado administrativo no ingresa un User  pero si un Password  y presiona el boton de login
    Then el sistema debera retornar un mensaje en pantalla Username cannot be empty

  Scenario: Login fallido falta de campo password
    When el empleado administrativo ingresa un User pero no un Password  y presiona el boton de login
    Then el sistema debera retornar un mensaje en pantalla Password cannot be empty

  Scenario: Login sin datos
    When el empleado administrativo no ingresa un User ni un Password  y presiona el boton de login
    Then el sistema debera retornar una alerta en pantalla Username cannot be empty



