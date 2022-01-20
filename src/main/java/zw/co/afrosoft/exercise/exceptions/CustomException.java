package zw.co.afrosoft.exercise.exceptions;

public class CustomException extends IllegalArgumentException{
    public CustomException(String msg) {
        super(msg);
    }
}
