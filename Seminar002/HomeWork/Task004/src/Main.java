//К калькулятору из предыдущего дз добавить логирование.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double first = numInput();
        String mathOperation = inputOperation();
        double second = numInput();
        double result = result(first, second, mathOperation);
        System.out.printf("%f %s %f = %f\n", first, mathOperation, second, result);
        logger(first, mathOperation, second, result);
    }

    private static void logger(double first, String mathOperation, double second, double result){
        try {
            File log = new File("calc.log");
            log.createNewFile();
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        Path path = Paths.get("calc.log");
        String logMessage = "" + first + " " + mathOperation + " " + second + " = " + result + "\n";

        try {
            Files.write(path, logMessage.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Это успех. Все ходы записаны.");
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