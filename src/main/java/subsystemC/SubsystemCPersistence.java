package subsystemC;

import java.io.*;

public class SubsystemCPersistence {
    private static final String FILE_PATH = "data/subsystemC.txt";

    public void save(FinalTranscript transcript) {
        new File("data").mkdirs();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(transcript.getId() + "," + transcript.getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}