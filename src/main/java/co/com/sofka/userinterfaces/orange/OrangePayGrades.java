package co.com.sofka.userinterfaces.orange;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;


public class OrangePayGrades extends PageObject {


    public static final Target ADMIN_MENU = Target
            .the("adminMenu")
            .located(id("menu_admin_viewAdminModule"));

    public static final Target ADMIN_MENU_JOB = Target
            .the("adminMenuJob")
            .located(id("menu_admin_Job"));

    public static final Target SUB_PAYGRADES = Target
            .the("subPayGrades")
            .located(id("menu_admin_viewPayGrades"));

    public static Target GRADE_ELETION = Target
            .the("gradeElection")
            .located(xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a"));

    public static final Target SELECT_ALL = Target
            .the("selectAll")
            .located(id("currencyCheckAll"));

    public static final Target BTN_DELETE = Target
            .the("btnDelete")
            .located(id("btnDeleteCurrency"));


    public static final Target BTN_ADD_CURRENCY = Target
            .the("btnAddCurrency")
            .located(id("btnAddCurrency"));

    public static final Target MONEDA = Target
            .the("moneda")
            .located(id("payGradeCurrency_currencyName"));

    public static final Target MIN_SALARY = Target
            .the("minSalary")
            .located(id("payGradeCurrency_minSalary"));

    public static final Target MAX_SALARY = Target
            .the("maxSalary")
            .located(id("payGradeCurrency_maxSalary"));

    public static final Target BTN_SABE_CURRECY = Target
            .the("btnSaveCurrency")
            .located(id("btnSaveCurrency"));


    //cuando ya esta registrada
    public static final Target ASSERTION_PAY_GRADES_TABLE = Target
            .the("assertionPayGrades")
            .located(xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[2]/a"));

    public static final Target ADD_EXITOSO = Target
            .the("addExitoso")
            .located(className("message success fadable"));


}



