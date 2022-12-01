//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.

//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String START = "SELECT * FROM students WHERE ";
        String INPUT = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        SqlBuilder(START, INPUT);
    }

    public static void SqlBuilder(String startString, String inputString){
        inputString = inputString.replace("{", "").replace("}","").
                replace('"', ' ').replace(" ", "");
        String[] paramsArray = inputString.split(",");
        List<String> finalParams = new ArrayList<>();
        StringBuilder SqlQuery = new StringBuilder(startString);
        for (String j : paramsArray){
            if (!j.contains("null")) {finalParams.add(j);}
        }
        for (String j : finalParams){
            if (!j.equals(finalParams.get(finalParams.size()-1))){
                SqlQuery.append(j.split(":")[0]).append(" = ").
                        append("'").append(j.split(":")[1]).append("'").append(" AND ");
            }
            else {
                SqlQuery.append(j.split(":")[0]).append(" = ").
                        append("'").append(j.split(":")[1]).append("'");
            }
        }
        System.out.println(SqlQuery);
    }
}