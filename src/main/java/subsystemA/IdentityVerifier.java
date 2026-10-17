package subsystemA;

public class IdentityVerifier {
    public boolean verifyStudent(String studentId) {
        return studentId != null && !studentId.isEmpty();
    }
}