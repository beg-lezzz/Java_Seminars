import java.io.IOException;

public interface Writable {
    void writeToFile() throws IOException;
    Object readFromFile();
}
