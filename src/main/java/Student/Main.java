package Student;

import CombinatorPattern.StudentRegistrationValidator;

import java.time.LocalDate;

import static CombinatorPattern.StudentRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        _Student student = new _Student(
                "Nametsego",
                "NametsegoThakadu@gmail.com",
                "Cyber Security",
                "NWA4566",
                LocalDate.of(2017, 9,30)
        );


        // If valid we can store student in db

        ValidationResult result = isEmailValid()
                .and(isStudentIDValid())
                .and(isGrad())
                .apply(student);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }

}
