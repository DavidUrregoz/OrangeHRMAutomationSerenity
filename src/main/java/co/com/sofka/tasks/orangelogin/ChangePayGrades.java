package co.com.sofka.tasks.orangelogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.sofka.userinterfaces.orange.OrangeLogin.*;
import static co.com.sofka.userinterfaces.orange.OrangeLogin.BTNLOGIN;
import static co.com.sofka.userinterfaces.orange.OrangePayGrades.*;
import static co.com.sofka.userinterfaces.orange.OranleSearch.SEARCH_OPTION;
import static org.openqa.selenium.By.xpath;

public class ChangePayGrades implements Task {
    private String grado;
    private String moneda;
    private String salarioMinimo;
    private String salarioMaximo;


    public ChangePayGrades usingGrado(String grado) {
        this.grado=grado;
        return this;
    }

    public ChangePayGrades usingMoneda(String moneda) {
        this.moneda=moneda;
        return this;
    }

    public ChangePayGrades usingSalarioMinimo(String salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
        return this;
    }

    public ChangePayGrades usingSalarioMaximo(String salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                //Scroll.to(ADMIN_MENU),
                Click.on(ADMIN_MENU),

                //Scroll.to(ADMIN_MENU_JOB),
                Click.on(ADMIN_MENU_JOB),

                //Scroll.to(SUB_PAYGRADES),
                Click.on(SUB_PAYGRADES),

                //Scroll.to(GRADE_ELETION),
                Click.on(GRADE_ELETION),

                //Scroll.to(SELECT_ALL),
                Click.on(SELECT_ALL),

                //Scroll.to(BTN_DELETE),
                Click.on(BTN_DELETE),

                //Scroll.to(BTN_ADD_CURRENCY),
                Click.on(BTN_ADD_CURRENCY),

                Scroll.to(MONEDA),
                Enter.theValue(this.moneda).into(MONEDA),
                Hit.the(Keys.TAB).into(MONEDA),

                Scroll.to(MIN_SALARY),
                Enter.theValue(this.salarioMinimo).into(MIN_SALARY),
                Hit.the(Keys.TAB).into(MIN_SALARY),

                Scroll.to(MAX_SALARY),
                Enter.theValue(this.salarioMaximo).into(MAX_SALARY),
                Hit.the(Keys.TAB).into(MAX_SALARY),

                Scroll.to(BTN_SABE_CURRECY),
                Click.on(BTN_SABE_CURRECY)

        );
    }

    public static ChangePayGrades changePayGrades(){
        return new ChangePayGrades();
    }

}




