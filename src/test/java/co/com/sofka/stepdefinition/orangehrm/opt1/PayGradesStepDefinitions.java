package co.com.sofka.stepdefinition.orangehrm.opt1;

import co.com.sofka.exceptions.orange.ValidationMach;
import co.com.sofka.stepdefinition.Setup;
import co.com.sofka.tasks.orangelogin.ChangePayGrades;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.orange.ValidationMach.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.orange.AssertUpdatePayGrades.assertUpdatePayGrades;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.orangelogin.ChangePayGrades.changePayGrades;
import static co.com.sofka.tasks.orangelogin.FillLogin.fillLogin;
import static co.com.sofka.userinterfaces.orange.OrangePayGrades.ASSERTION_PAY_GRADES_TABLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PayGradesStepDefinitions extends Setup {
    private static final String ACTOR_NAME = "Admin";
    @Given("el empleado administrativo se encuentra logueado en la web de OrangeHRM")
    public void el_empleado_administrativo_se_encuentra_logueado_en_la_web_de_OrangeHRM() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandingPage()
        );
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUser("Admin")
                        .usingPassword("admin123")
        );

    }

    @When("el empleado administrativo se encuentre en la seccion de Job Pay Grades y modifique los grados de pago ya establecidos.")
    public void el_empleado_administrativo_se_encuentre_en_la_seccion_de_Job_Pay_Grades_y_modifique_los_grados_de_pago_ya_establecidos() {
        theActorInTheSpotlight().attemptsTo(
                changePayGrades()
                        .usingGrado("1")
                        .usingMoneda("USD")
                        .usingSalarioMinimo("2000")
                        .usingSalarioMaximo("3000")

        );
    }

    @Then("el sistema debe guardar exitosamente los cambios anteriormente realizados..")
    public void el_sistema_debe_guardar_exitosamente_los_cambios_anteriormente_realizados() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertUpdatePayGrades()
                                //Informacion de assercion por mensaje
                                //.wasMessage(" Successfully Saved ")
                                .wasMessage("United States Dollar")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Successfully Saved "+ASSERTION_PAY_GRADES_TABLE )
                        )
        );
    }

}
