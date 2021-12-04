package tech.grtarrays.employeemanager.exception;

public class UserPrincipalNotFoundException extends RuntimeException {
    public UserPrincipalNotFoundException(String message) {
        super(message);
    }
}
