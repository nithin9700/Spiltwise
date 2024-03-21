package Nithin.SplitWise.exception;

public class UserLoginInvalidException extends  RuntimeException{
    public UserLoginInvalidException() {
    }

    public UserLoginInvalidException(String message) {
        super(message);
    }
}
