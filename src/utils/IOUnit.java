package utils;

import java.util.Scanner;

public class IOUnit {
    private static Scanner reader = new Scanner(System.in);

    private static void handleError(String msg, boolean isInteractive) {
        System.out.println(msg);
        if (isInteractive) {
            System.out.println("Enter = повторить ввод, любая другая клавиша + Enter = выход:");
            if (reader.nextLine().isEmpty()) {
                return;
            }
        }
        System.out.println("Программа завершает работу.");
        System.exit(-1);
    }

    public static byte chooseMode() {
        byte mode;
        while (true) {
            System.out.println("Выберите режим работы программы (0 - решить нелинейное уравнение, 1 - решить систему нелинейных уравнений):");
            String tmp = reader.nextLine();
            try {
                mode = Byte.parseByte(tmp);
                if (mode < 0 || mode > 1) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести 0 для решения нелинейного уравнения, 1 - для системы нелинейных уравнений.", true);
            }
        }
        return mode;
    }

    public static byte chooseEquation() {
        byte id;
        while (true) {
            printEquations();
            System.out.println("Введите номер нужного уравнения:");
            String tmp = reader.nextLine();
            try {
                id = Byte.parseByte(tmp);
                if (id < 1 || id > 5) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести целое число от 1 до 5.", true);
            }
        }
        return id;
    }

    public static byte chooseSystems() {
        byte id;
        while (true) {
            printSystems();
            System.out.println("Введите номер нужной системы:");
            String tmp = reader.nextLine();
            try {
                id = Byte.parseByte(tmp);
                if (id < 1 || id > 5) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести целое число от 1 до 5.", true);
            }
        }
        return id;
    }

    public static void printEquations() {
        System.out.println("Список уравнений, которые можно решить:");
        System.out.println("1. x^3-2x^2-5x+6=0");
        System.out.println("2. x^2-cos(x)+x=0");
        System.out.println("3. e^(x-2x^5)-7=0");
        System.out.println("4. x+1+ln(x-3)=0");
        System.out.println("5. x^4+10x^2-tg(x)=0");
    }

    public static void printSystems() {
        System.out.println("Список систем, которые можно решить:");
        System.out.println("1. x^3-2x^2-5x+6=0");
        System.out.println("2. x^2-cos(x)+x=0");
        System.out.println("3. e^(x-2x^5)-7=0");
        System.out.println("4. x+1+ln(x-3)=0");
        System.out.println("5. x^4+10x^2-tg(x)=0");
    }
}
