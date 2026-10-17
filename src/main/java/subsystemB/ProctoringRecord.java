package subsystemB;

public class ProctoringRecord {
    private String id;
    private String sessionId;
    private String status;

    public ProctoringRecord(String id, String sessionId, String status) {
        this.id = id;
        this.sessionId = sessionId;
        this.status = status;
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}