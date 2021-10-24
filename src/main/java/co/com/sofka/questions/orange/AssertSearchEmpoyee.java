package co.com.sofka.questions.orange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.orange.OranleSearch.ASSERTION_SEARC;


public class AssertSearchEmpoyee implements Question<Boolean> {

    private String searchEmpoyee;

    public AssertSearchEmpoyee wasSearchEmpoyee(String searchEmpoyee) {
        this.searchEmpoyee=searchEmpoyee;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(ASSERTION_SEARC.resolveFor(actor).containsOnlyText(searchEmpoyee));
        return (ASSERTION_SEARC.resolveFor(actor).containsOnlyText(searchEmpoyee));
    }

    public AssertSearchEmpoyee is(){
        return this;
    }

    public static AssertSearchEmpoyee assertSearchEmpoyee(){
        return new AssertSearchEmpoyee();
    }

}





