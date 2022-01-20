package zw.co.afrosoft.exercise.exceptions;

public class LecturerNotFoundException extends IllegalArgumentException{
    public LecturerNotFoundException(String msg) {
        super(msg);
    }
}
