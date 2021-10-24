package co.com.sofka.tasks.orangelogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.Keys;

import static co.com.sofka.userinterfaces.orange.OranleSearch.*;


public class SearchEmpoyee implements Task {
    private String employeName;

    public SearchEmpoyee usingEmployeName(String employeName) {
        this.employeName = employeName;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ADMIN_MENU),
                Click.on(ADMIN_MENU),

                Scroll.to(SEARCH_OPTION),
                Enter.theValue(this.employeName).into(SEARCH_OPTION),
                Hit.the(Keys.TAB).into(SEARCH_OPTION),

                Scroll.to(SEARCH_BUTON),
                Click.on(SEARCH_BUTON)

        );
    }
    public static SearchEmpoyee searchEmpoyee(){
        return new SearchEmpoyee();
    }

}
