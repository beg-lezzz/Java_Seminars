//Дана json строка (можно сохранить в файл и читать из файла)
//
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет].
//
//Пример вывода:
//
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

public class Main {
    public static void main(String[] args) {
        String inputString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                             "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                             "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        stringParser(inputString);
    }

    public static void stringParser(String inputString){
        inputString = inputString.replace("[", "").replace("]","").
                replace("{", "").replace('"', ' ').replace(" ", "");
        String[] jsonArray = inputString.split("},");
        for (String strings : jsonArray){
            String[] elems = strings.replace("}", "").split(",");
            StringBuilder fullString = new StringBuilder();
            for (String part : elems){
                switch (part.split(":")[0]){
                    case ("фамилия"):
                        fullString.append("Студент ").append(part.split(":")[1]);
                        break;
                    case ("оценка"):
                        fullString.append(" получил ").append(part.split(":")[1]);
                        break;
                    case ("предмет"):
                        fullString.append(" по предмету ").append(part.split(":")[1]);
                        break;
                }
            }
            System.out.println(fullString);
        }
    }
}