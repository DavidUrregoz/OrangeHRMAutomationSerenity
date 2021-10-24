package co.com.sofka.userinterfaces.orange;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
public class OrangeLogin extends PageObject {
    public static final Target NAME = Target
            .the("name")
            .located(id("txtUsername"));

    public static final Target PASSWORD =Target
            .the("password")
            .located(id("txtPassword"));

    public static final Target BTNLOGIN = Target
            .the("botonLogin")
            .located(id("btnLogin"));


    public static final Target ASSRET_WELCOME = Target
            .the("assertWelcome")
            .located(id("welcome"));

    public static final Target ASSRET_SPAM = Target
            .the("assertSpam")
            .located(id("spanMessage"));


//    public static final Target ASSRET_SEARCH= Target
//            .the("assertSearch")
//            .located(xpath("\"//*[@id=\\\"resultTable\\\"]/tbody/tr/td[4]\""));
//

}
