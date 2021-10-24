Feature:Como Empleado admistrativo
    necesito actualizar la información de pagos de los empleados
    con el fin mantener al día las nominas de la empresa en la base de datos.

    Background:
        Given el empleado administrativo se encuentra logueado en la web de OrangeHRM

    Scenario: Modificacion de grado de pago
        When el empleado administrativo se encuentre en la seccion de Job Pay Grades y modifique los grados de pago ya establecidos.
        Then el sistema debe guardar exitosamente los cambios anteriormente realizados..