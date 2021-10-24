package co.com.sofka.stepdefinition.orangehrm.opt1;

import co.com.sofka.exceptions.orange.ValidationMach;
import co.com.sofka.questions.orange.AssertLoginWelcome;
import co.com.sofka.questions.orange.AssertloginFail;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.orange.ValidationMach.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.orange.AssertLoginWelcome.assertLoginWelcome;
import static co.com.sofka.questions.orange.AssertloginFail.assertloginFail;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.orangelogin.FillLogin.fillLogin;
import static co.com.sofka.userinterfaces.orange.OrangeLogin.ASSRET_SPAM;
import static co.com.sofka.userinterfaces.orange.OrangeLogin.ASSRET_WELCOME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class LoginStepDefinitions extends Setup {


    private static final String ACTOR_NAME = "Admin";
    @Given("que el empleado administrativo se encuentra en la pagina web de OrangeHRM  en el formulario de inicio login")
    public void que_el_empleado_administrativo_se_encuentra_en_la_pagina_web_de_OrangeHRM_en_el_formulario_de_inicio_login() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                  openLandingPage()
        );
    }

    @When("el empleado administrativo ingresa un User y Password correctos y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_User_y_Password_correctos_y_presiona_el_boton_de_login() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("Admin")
                        .usingPassword("admin123")
        );
    }

    @Then("el sistema debera ingresar exitosamente a la pagina de index.php\\/dashboard")
    public void el_sistema_debera_ingresar_exitosamente_a_la_pagina_de_index_php_dashboard() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertLoginWelcome()
                                .wasSpamWelcome("Welcome Paul")
                                .is(),equalTo(true)
                        )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH,"wolcome"+ASSRET_WELCOME)
                        )
                );
    }



    @When("el empleado administrativo ingresa un User y Password incorrectos y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_User_y_Password_incorrectos_y_presiona_el_boton_de_login() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("cualquiera")
                        .usingPassword("malo")
        );
    }

    @Then("el sistema debera retornar un mensaje en pantalla Invalid credentials")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_Invalid_credentials() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertloginFail()
                                .wasAssertloginFail("Invalid credentials")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Invalid credentials and "+ASSRET_SPAM)
                        )
        );
    }

    @When("el empleado administrativo no ingresa un User  pero si un Password  y presiona el boton de login")
    public void el_empleado_administrativo_no_ingresa_un_User_pero_si_un_Password_y_presiona_el_boton_de_login() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("")
                        .usingPassword("admin123")
        );
    }

    @Then("el sistema debera retornar un mensaje en pantalla Username cannot be empty")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_Username_cannot_be_empty() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertloginFail()
                                .wasAssertloginFail("Username cannot be empty")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Username cannot be empty and "+ASSRET_SPAM)
                        )
        );
    }

    @When("el empleado administrativo ingresa un User pero no un Password  y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_User_pero_no_un_Password_y_presiona_el_boton_de_login() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("Admin")
                        .usingPassword("")
        );
    }

    @Then("el sistema debera retornar un mensaje en pantalla Password cannot be empty")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_Password_cannot_be_empty() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertloginFail()
                                .wasAssertloginFail("Password cannot be empty")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Password cannot be empty and "+ASSRET_SPAM)
                        )
        );
    }

    @When("el empleado administrativo no ingresa un User ni un Password  y presiona el boton de login")
    public void el_empleado_administrativo_no_ingresa_un_User_ni_un_Password_y_presiona_el_boton_de_login() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("")
                        .usingPassword("")
        );
    }

    @Then("el sistema debera retornar una alerta en pantalla Username cannot be empty")
    public void el_sistema_debera_retornar_una_alerta_en_pantalla_Username_cannot_be_empty() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertloginFail()
                                .wasAssertloginFail("Username cannot be empty")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Username cannot be empty "+ASSRET_SPAM)
                        )
        );
    }

}


