package srp.recorders;

import java.io.IOException;

public interface Recorder {
    void createDirectory(String dir);

    void createFile(String fileName);

    void recordFile(String data) throws IOException;
}
