package co.com.sofka.userinterfaces.orange;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class OranleSearch extends PageObject {

    public static final Target ADMIN_MENU= Target
            .the("adminMenu")
            .located(id("menu_admin_viewAdminModule"));

    public static final Target SEARCH_OPTION = Target
            .the("searchOption")
            .located(id("searchSystemUser_employeeName_empName"));

    public static final Target SEARCH_BUTON = Target
            .the("searchButon")
            .located(id("searchBtn"));

    public static final Target ASSERTION_SEARC = Target
            .the("assertionSearc")
            .located(xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]"));


}




