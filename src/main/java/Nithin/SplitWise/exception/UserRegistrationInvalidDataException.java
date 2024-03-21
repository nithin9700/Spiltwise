package Nithin.SplitWise.exception;

public class UserRegistrationInvalidDataException extends RuntimeException{
    public UserRegistrationInvalidDataException() {
    }

    public UserRegistrationInvalidDataException(String message) {
        super(message);
    }
}
