package co.com.sofka.exceptions.orange;



public class ValidationMach extends AssertionError {
    public static final String VALIDATION_DO_NOT_MATCH = "The validation don't match. %s";

    public ValidationMach(String message, Throwable cause){
        super(message, cause);
    }

}
