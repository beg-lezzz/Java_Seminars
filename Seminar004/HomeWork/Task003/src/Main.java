import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        mainFunc();
    }

    private static void mainFunc() {
        double first = numInput();
        String mathOperation = inputOperation();
        double second = numInput();
        double result = result(first, second, mathOperation);
        System.out.printf("%f %s %f = %f\n", first, mathOperation, second, result);
        String logMessage = "" + first + " " + mathOperation + " " + second + " = " + result;
        cancelOperation(logMessage);
    }

    private static void cancelOperation(String inputString) {
        Stack<String> operationQueue = new Stack<>();
        operationQueue.push(inputString);
        if (answerInput()) {
            logger(inputString, 0);
            mainFunc();
        } else {
            System.out.printf("Операция %s отменена\n", operationQueue.pop());
            logger(inputString, 1);
        }
    }

    public static boolean answerInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        boolean answer = true;
        String n = "";
        while (check) {
            System.out.print("\nВыхотите сохранить операцию и продолжить? (Y/N): ");
            try {
                n = in.nextLine();
                if (n.equalsIgnoreCase("Y")) {
                    answer = true;
                    check = false;
                } else if (n.equalsIgnoreCase("N")) {
                    answer = false;
                    check = false;
                } else {
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Да - Y или Нет - N");
                }
            }
            catch (Exception e) {
                System.out.println("Стоп! Давайте еще разок попробуем. " +
                        "Да - Y или Нет - N");
            }
        }
        return answer;
    }


    private static void logger(String logMessage, int logType){
        if (logType == 1) {
            logMessage = LocalDateTime.now() + "\t" + logMessage + "\t(отменено пользователем)" + "\n";
        } else {
            logMessage = LocalDateTime.now() + "\t" +logMessage + "\n";
        }
        try {
            File log = new File("calc.log");
            log.createNewFile();
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        Path path = Paths.get("calc.log");

        try {
            Files.write(path, logMessage.getBytes(), StandardOpenOption.APPEND);
            System.out.println("\nЭто успех. Все ходы записаны.");
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Лог не записан.");
            e.printStackTrace();
        }
    }
    public static String inputOperation() {
        boolean check = true;
        String math_operation = null;

        while (check) {
            System.out.print("Введите операцию (+, -, /, *): ");
            Scanner in = new Scanner(System.in);
            math_operation = (String) in.nextLine();
            if (Objects.equals("+", math_operation) || Objects.equals("-", math_operation) ||
                    Objects.equals("/", math_operation) || Objects.equals("*", math_operation)) {
                check = false;
            }
            else {
                System.out.println("Ошибка. Необходимо вводить символ (+, -, /, *)");
            }
        }
        return math_operation;
    }

    public static double result(double first, double second, String mathOperation) {
        Double res = null;
        switch (mathOperation) {
            case ("+"):
                res = numSum(first, second);
                break;
            case ("-"):
                res = numSub(first, second);
                break;
            case ("/"):
                res = numDiv(first, second);
                break;
            case ("*"):
                res = numMul(first, second);
                break;
        }
        return res;
    }

    public static double numInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Double n = null;
        while (check) {
            System.out.print("Введите число: ");
            try {
                n = Double.parseDouble(in.nextLine().replaceAll(",", "."));
                check = false;
            }
            catch (Exception e) {
                System.out.println("Ошибка! Необходимо вводить число");
            }
        }
        return n;
    }

    public static double numSum ( double first, double second){
        return first + second;
    }

    public static double numSub ( double first, double second){
        return first - second;
    }

    public static double numDiv ( double first, double second){
        return first / second;
    }

    public static double numMul ( double first, double second){
        return first * second;
    }
}