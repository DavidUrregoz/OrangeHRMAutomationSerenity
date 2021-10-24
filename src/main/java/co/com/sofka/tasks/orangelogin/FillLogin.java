package co.com.sofka.tasks.orangelogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.orange.OrangeLogin.*;

public class FillLogin implements Task {

    private String user;
    private String password;

    public FillLogin usingUser(String user) {
        this.user = user;
        return this;
    }

    public FillLogin usingPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(NAME),
                Enter.theValue(this.user).into(NAME),

                Scroll.to(PASSWORD),
                Enter.theValue(this.password).into(PASSWORD),

                Scroll.to(BTNLOGIN),
                Click.on(BTNLOGIN)
        );
    }

    public static FillLogin fillLogin(){
        return new FillLogin();
    }
}
