package utils;

import java.util.Locale;
import java.util.Scanner;

import static utils.Convertor.toLowerIndex;
import static utils.Storage.getEqStorage;
import static utils.Storage.getSysStorage;

public class IOUnit {
    private static final Scanner reader = new Scanner(System.in);

    private static void handleError(String msg) {
        System.out.println(msg);
        System.out.println("Enter = повторить ввод, любая другая клавиша + Enter = выход:");
        if (reader.nextLine().isEmpty()) {
            return;
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
                handleError("Ошибка ввода! Требуется ввести 0 для решения нелинейного уравнения, 1 - для системы нелинейных уравнений.");
            }
        }
        return mode;
    }

    public static int chooseEq() {
        int id;
        while (true) {
            printEqStorage();
            System.out.println("Введите номер нужного уравнения:");
            String tmp = reader.nextLine();
            try {
                id = Integer.parseInt(tmp);
                if (id < 1 || id > getEqStorage().size()) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести целое число от 1 до " + getEqStorage().size() + " - номер нужного уравнения.");
            }
        }
        return id;
    }

    public static int chooseSys() {
        int id;
        while (true) {
            printSysStorage();
            System.out.println("Введите номер нужной системы:");
            String tmp = reader.nextLine();
            try {
                id = Integer.parseInt(tmp);
                if (id < 1 || id > getSysStorage().size()) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести целое число от 1 до " + getSysStorage().size() + " - номер нужной системы.");
            }
        }
        return id;
    }

    public static void printEqStorage() {
        System.out.println("Список уравнений, которые можно решить:");
        for (int i = 0; i < getEqStorage().size(); i++) {
            System.out.println((i + 1) + ". " + getEqStorage().get(i));
        }
    }

    public static void printSysStorage() {
        System.out.println("Список систем, которые можно решить:");
        for (int i = 0; i < getSysStorage().size(); i++) {
            System.out.print((i + 1) + ". " + getSysStorage().get(i));
        }
    }

    public static void printSysSolution(double[] x, double[] diff, long timeInNanos, int count) {
        System.out.println("Значение eps: 0.000001");
        System.out.println("Время работы метода: " + (double) timeInNanos / 1000000 + "мс");
        System.out.println("Количество итераций: " + count);
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + toLowerIndex(i + 1) + " = " + String.format(Locale.ENGLISH, "%.6f", x[i]) + ";\tневязка: " + diff[i]);
        }
    }

    public static void printEqSolution(double a, double b, double bisectX, long bisectTime, double secantX, long secantTime) {
        System.out.println("Значение eps: 0.000001");
        System.out.println("Значение границы a: " + a);
        System.out.println("Значение границы b: " + b);
        System.out.println("Время работы метода половинного деления: " + (double) bisectTime / 1000000 + "мс");
        System.out.println("Результат: " + String.format(Locale.ENGLISH, "%.6f", bisectX));
        System.out.println("Время работы метода хорд: " + (double) secantTime / 1000000 + "мс");
        System.out.println("Результат: " + String.format(Locale.ENGLISH, "%.6f", secantX));
    }
}
