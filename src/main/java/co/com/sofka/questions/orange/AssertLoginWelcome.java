package co.com.sofka.questions.orange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.orange.OrangeLogin.ASSRET_WELCOME;

public class AssertLoginWelcome implements Question<Boolean> {

    private String spamWeolcome;

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(ASSRET_WELCOME.resolveFor(actor).containsOnlyText(spamWeolcome));
        return (ASSRET_WELCOME.resolveFor(actor).containsOnlyText(spamWeolcome));//toString().equals(spamWeolcome));
    }

    public AssertLoginWelcome wasSpamWelcome(String spamWeolcome){
        this.spamWeolcome=spamWeolcome;
        return this;
    }

    public AssertLoginWelcome is(){
        return this;
    }
    public static AssertLoginWelcome assertLoginWelcome(){
        return new AssertLoginWelcome();
    }

}
