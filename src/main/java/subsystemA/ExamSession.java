package subsystemA;

public class ExamSession {
    private String id;
    private String studentId;
    private String status;

    public ExamSession(String id, String studentId, String status) {
        this.id = id;
        this.studentId = studentId;
        this.status = status;
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}