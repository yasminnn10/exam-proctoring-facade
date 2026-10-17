package facade;

import subsystemA.*;
import subsystemB.*;
import subsystemC.*;
import java.io.*;

public class ProctoringFacade {
    private SubsystemAPersistence repoA = new SubsystemAPersistence();
    private SubsystemBPersistence repoB = new SubsystemBPersistence();
    private SubsystemCPersistence repoC = new SubsystemCPersistence();

    public void runExamChain(String studentId, boolean failAtB, boolean failAtC) {
        IdentityVerifier verifier = new IdentityVerifier();
        if (!verifier.verifyStudent(studentId)) {
            throw new RuntimeException("Validation failed at Subsystem A");
        }

        ExamSession session = new ExamSession("S1", studentId, "VERIFIED");
        repoA.save(session);
        saveProgress("PENDING_B");

        if (failAtB) {
            session.setStatus("CANCELLED");
            repoA.save(session);
            saveProgress("COMPENSATED_A");
            System.out.println(">>> Error at Step B! Subsystem A is compensated (CANCELLED).");
            return;
        }

        ProctoringRecord record = new ProctoringRecord("R1", session.getId(), "MONITORED");
        repoB.save(record);
        saveProgress("PENDING_C");

        if (failAtC) {
            record.setStatus("FAILED");
            repoB.save(record);

            session.setStatus("CANCELLED");
            repoA.save(session);

            saveProgress("COMPENSATED_ALL");
            System.out.println(">>> Error at Step C! Rollback performed: Subsystem B (FAILED), Subsystem A (CANCELLED).");
            return;
        }

        FinalTranscript transcript = new FinalTranscript("T1", record.getId(), 95, "RECORDED");
        repoC.save(transcript);
        saveProgress("COMPLETED");
        System.out.println(">>> Chain A -> B -> C completed successfully!");
    }

    private void saveProgress(String status) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data/progress.txt"))) {
            writer.println(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}