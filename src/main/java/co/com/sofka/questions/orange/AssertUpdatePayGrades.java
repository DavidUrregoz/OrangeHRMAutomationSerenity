
package co.com.sofka.questions.orange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.orange.OrangePayGrades.ASSERTION_PAY_GRADES_TABLE;

public class AssertUpdatePayGrades implements Question<Boolean> {

    private String message;

    public AssertUpdatePayGrades wasMessage(String message) {
        this.message = message;
        return this;
    }
    public AssertUpdatePayGrades is(){
        return this;
    }

    public static AssertUpdatePayGrades assertUpdatePayGrades(){
        return new AssertUpdatePayGrades();
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        //Linea para funcionalidad de la assercion con el mensaje de agregado exitoso
        //return (ADD_EXITOSO.resolveFor(actor).containsOnlyText(message));
        return (ASSERTION_PAY_GRADES_TABLE.resolveFor(actor).containsOnlyText(message));
    }

}
