package zw.co.afrosoft.exercise.exceptions;

public class CourseNotFoundException extends IllegalArgumentException {
    public CourseNotFoundException(String msg){
        super(msg);
    }
}
