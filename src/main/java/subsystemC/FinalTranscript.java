package subsystemC;

public class FinalTranscript {
    private String id;
    private String recordId;
    private int grade;
    private String status;

    public FinalTranscript(String id, String recordId, int grade, String status) {
        this.id = id;
        this.recordId = recordId;
        this.grade = grade;
        this.status = status;
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}