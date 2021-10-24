package co.com.sofka.stepdefinition.orangehrm.opt1;

import co.com.sofka.exceptions.orange.ValidationMach;
import co.com.sofka.questions.orange.AssertSearchEmpoyee;
import co.com.sofka.stepdefinition.Setup;
import co.com.sofka.tasks.orangelogin.SearchEmpoyee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.orange.ValidationMach.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.orange.AssertLoginWelcome.assertLoginWelcome;
import static co.com.sofka.questions.orange.AssertSearchEmpoyee.assertSearchEmpoyee;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.orangelogin.FillLogin.fillLogin;
import static co.com.sofka.tasks.orangelogin.SearchEmpoyee.searchEmpoyee;
import static co.com.sofka.userinterfaces.orange.OrangeLogin.ASSRET_WELCOME;
import static co.com.sofka.userinterfaces.orange.OranleSearch.ASSERTION_SEARC;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SearchStepDefinitions extends Setup {

    private static final String ACTOR_NAME = "Admin";

    @Given("que el empleado administrativo se encuentra correctamente autenticado en la aplicacion de orangeHRM")
    public void queElEmpleadoAdministrativoSeEncuentraCorrectamenteAutenticadoEnLaAplicacionDeOrangeHRM() {
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

    @When("el empleado proceda a hacer una busqueda en la sesion de Admin  por medio del Employee name")
    public void elEmpleadoProcedaAHacerUnaBusquedaEnLaSesionDeAdminPorMedioDelEmployeeName() {
        theActorInTheSpotlight().attemptsTo(
                searchEmpoyee()
                        .usingEmployeName("Aaliyah Haq")
        );
    }

    @Then("el sistema debe retornar una lista con la informacion filtrada.")
    public void elSistemaDebeRetornarUnaListaConLaInformacionFiltrada() {
        theActorInTheSpotlight().should(
                seeThat(
                        assertSearchEmpoyee()
                                .wasSearchEmpoyee("Aaliyah Haq")
                                .is(),equalTo(true)
                )
                        .orComplainWith(
                                ValidationMach.class,
                                String.format(VALIDATION_DO_NOT_MATCH," Aaliyah Haq and "+ ASSERTION_SEARC)
                        )
        );
    }


}
