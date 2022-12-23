import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWorker implements Writable{
    @Override
    public void writeToFile() throws IOException {
        try {
            File tree = new File("calc.log");
            tree.createNewFile();
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        Path path = Paths.get("calc.log");
        String str = this.toString();

        Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public Object readFromFile() {
        return null;
    }
}
