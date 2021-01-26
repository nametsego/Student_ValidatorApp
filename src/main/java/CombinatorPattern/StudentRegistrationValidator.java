package CombinatorPattern;
import Student._Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static CombinatorPattern.StudentRegistrationValidator.ValidationResult.*;

public interface StudentRegistrationValidator
        extends Function<_Student, StudentRegistrationValidator.ValidationResult> {

    static StudentRegistrationValidator isEmailValid (){
        return student -> {
            System.out.println("Deploying Email validation");
            return student.getEmail().contains("@") ?
                    SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static StudentRegistrationValidator isStudentIDValid () {
        return student -> {
            System.out.println("Deploying Student Id validation");
            return student.getStudentId().contains("NWA") ?
                    SUCCESS : STUDENT_ID_NOT_VALID;
        };
    }


    static StudentRegistrationValidator isGrad(){
        return student ->
                Period.between(student.getYog(), LocalDate.now()).getYears() > 20 ?
                        SUCCESS : IS_NOT_GRADUATE_STUDENT;
    }

    default StudentRegistrationValidator and (StudentRegistrationValidator other){
        return student -> {
            ValidationResult result = this.apply(student);
           return  result.equals(SUCCESS) ? other.apply(student) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        STUDENT_ID_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_GRADUATE_STUDENT
    }

}
