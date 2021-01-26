package Student;

import java.time.LocalDate;

public class _Student {

    private final String name;
    private final String email;
    private final String rankMajor;
    private final String studentId;
    private final LocalDate yog;

    public _Student(String name, String email, String rankMajor, String studentId, LocalDate yog){
        this.name = name;
        this.email = email;
        this.rankMajor = rankMajor;
        this.studentId = studentId;
        this.yog = yog;

    }

    public String getName() {
        return name;
    }

    public  String getEmail() {
        return email;
    }

    public String getRankMajor() {
        return rankMajor;
    }

    public String getStudentId() {
        return studentId;
    }

    public LocalDate getYog() {
        return yog;
    }
}
