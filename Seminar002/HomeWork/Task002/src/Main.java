//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    private static FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
        try {
            File logger = new File("bubbleSort.log");
            logger.createNewFile();
            fileWriter = new FileWriter(logger);
            Integer[] ARRAY = {5, 29, 45, 0, -1};
            bubbleSort(ARRAY);
        }
        catch (Exception e) {e.getLocalizedMessage();}
        finally {fileWriter.close();}
    }

    public static void bubbleSort(Integer[] inputArray) throws IOException {
        System.out.printf("Первоначальный массив ===> %s\n", Arrays.toString(inputArray));
        for (int i = 0; i < inputArray.length - 1; i++){
            for(int j = 0; j < inputArray.length - 1; j++){
                if (inputArray[j] > inputArray[j + 1]){
                    int tmp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmp;
                    logSortOperations(inputArray[j], inputArray[j+1], inputArray);
                }
            }
        }
        System.out.printf("Отсортированный массив ===> %s\n", Arrays.toString(inputArray));
        System.out.println("Записи логов успешно произведены");
    }

    public static void logSortOperations(Integer i, Integer j, Integer[] inputArray) throws IOException {
        StringBuilder logString = new StringBuilder();
        logString.append(i).append(" <=> ").append(j).append(" ===> ").append(Arrays.toString(inputArray));
        try {
            fileWriter.append(String.valueOf(LocalDateTime.now())).append(" ").append(String.valueOf(logString)).append("\n");
        } catch (Exception e) {e.getLocalizedMessage();}
    }
}