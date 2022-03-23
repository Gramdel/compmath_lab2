import static utils.IOUnit.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для лабораторной работы №2!");

        byte mode = chooseMode();
        if (mode == 0) {
            chooseEquation();
        } else {
            chooseSystems();
        }
        System.out.println("Программа завершает работу.");
    }
}
