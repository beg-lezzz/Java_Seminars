import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputString = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        printSortedMapDesc(collectMap(inputString));
    }

    private static void printSortedMapDesc(LinkedHashMap countList) {
        countList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry);
        });
    }

    private static LinkedHashMap collectMap(String inputString) {
        List<String> inputList = new ArrayList<>();
        LinkedHashMap<String, Integer> countList = new LinkedHashMap<>();
        inputList = Arrays.asList(inputString.split(", "));
        for (String elem : inputList) {
            if (countList.containsKey(elem.split(" ")[0])){
                countList.put(elem.split(" ")[0], countList.get(elem.split(" ")[0]) + 1);
            } else {
                countList.put(elem.split(" ")[0], 1);
            }
        }
        return countList;
    }
}