package co.com.sofka.questions.orange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.orange.OrangeLogin.*;

public class OrangeQuestionLogin implements Question<Boolean> {
    private String spamName;
    private String spamPass;
    private String spamInvalid;
    private String welcome;

    public OrangeQuestionLogin wasSpamWelcome(){
        this.welcome= welcome;
        return this;
    }

    public OrangeQuestionLogin wasSpamFailName(){
        this.spamName = spamName;
        return this;
    }
    public OrangeQuestionLogin wasSpamFailPass(){
        this.spamPass = spamPass;
        return this;
    }
    public  OrangeQuestionLogin wasSpamFailInvalid(){
        this.spamInvalid = spamInvalid;
        return this;
    }
    public OrangeQuestionLogin is(){
        return this;
    }
    public static OrangeQuestionLogin orangeQuestionLogin(){
        return new OrangeQuestionLogin();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                ASSRET_WELCOME.resolveFor(actor).containsOnlyText(this.welcome)
                && (
                        ASSRET_SPAM.resolveFor(actor).containsOnlyText(this.spamName)
                        || ASSRET_SPAM.resolveFor(actor).containsOnlyText(this.spamPass)
                        || ASSRET_SPAM.resolveFor(actor).containsOnlyText(this.spamInvalid)
                    )
                );
    }
}
