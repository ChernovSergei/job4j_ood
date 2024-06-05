package srp.recorders;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVRecorder implements Recorder {

    private String directory;
    private String fileName;

    public CSVRecorder(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    @Override
    public void createDirectory(String dir) {
        Path newDir = Paths.get(dir);
        if (!Files.isDirectory(newDir)) {
            try {
                Files.createDirectories(newDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createFile(String fileName) {
        Path newFile = Path.of(fileName);
        if (!Files.isRegularFile(newFile)) {
            try {
                Files.createFile(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void recordFile(String data) {
        this.createDirectory(directory);
        this.createFile(directory + "/" + fileName);
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(directory + "/" + fileName)))) {
            output.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
