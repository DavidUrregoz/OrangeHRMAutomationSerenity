package co.com.sofka.questions.orange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.orange.OrangeLogin.ASSRET_SPAM;

public class AssertloginFail implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(ASSRET_SPAM.resolveFor(actor).containsOnlyText(spamFail));
        return (ASSRET_SPAM.resolveFor(actor).containsOnlyText(spamFail));//toString().equals(spamWeolcome));
    }

    private String spamFail;
    public AssertloginFail wasAssertloginFail(String spamFail){
        this.spamFail=spamFail;
        return this;
    }

    public AssertloginFail is(){
        return this;
    }

    public static AssertloginFail assertloginFail(){
        return new AssertloginFail();
    }

}


