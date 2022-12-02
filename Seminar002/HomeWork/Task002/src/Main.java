//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    private static FileWriter writer;

    public static void main(String[] args) throws IOException {
            Integer[] ARRAY = {5, 109, -145, -20, 10};
            bubbleSort(ARRAY);
    }

    public static void bubbleSort(Integer[] inputArray) throws IOException {

        System.out.printf("Первоначальный массив ===> %s\n", Arrays.toString(inputArray));
        String logMessage = "Первоначальный массив ===> " + Arrays.toString(inputArray) + "\n";
        logSortOperations(logMessage);
        for (int i = 0; i < inputArray.length - 1; i++){
            for(int j = 0; j < inputArray.length - 1; j++){
                if (inputArray[j] > inputArray[j + 1]){
                    int tmp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmp;
                    logMessage = "" + LocalDateTime.now() + " " + inputArray[j + 1] + " <=> " + inputArray[j] + " ===> "
                                    + Arrays.toString(inputArray) + "\n";
                    logSortOperations(logMessage);
                }
            }
        }
        System.out.printf("Отсортированный массив ===> %s\n", Arrays.toString(inputArray));
        logMessage = "Отсортированный массив ===> " + Arrays.toString(inputArray) + "\n\n";
        logSortOperations(logMessage);
        System.out.println("Все ходы записаны и хранятся в файле bubbleSort.log");
    }

    public static void logSortOperations(String logMessage) throws IOException {
        try {
            File log = new File("bubbleSort.log");
            log.createNewFile();
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        Path path = Paths.get("bubbleSort.log");
//        String logMessage = "" + i + " <=> " + j + " ===> " + Arrays.toString(inputArray) + "\n";

        try {
            Files.write(path, logMessage.getBytes(), StandardOpenOption.APPEND);
//            System.out.println("Это успех. Все ходы записаны.");
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Лог не записан.");
            e.printStackTrace();
        }

//        StringBuilder logString = new StringBuilder();
//        logString.append(i).append(" <=> ").append(j).append(" ===> ").append(Arrays.toString(inputArray));
//        try {
//            writer.append(String.valueOf(LocalDateTime.now())).append(" ").append(String.valueOf(logString)).append("\n");
//        } catch (Exception e) {e.getLocalizedMessage();}
    }
}