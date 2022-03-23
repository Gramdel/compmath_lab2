import static utils.IOUnit.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для лабораторной работы №2!");

        byte mode = chooseMode(), id;
        if (mode == 0) {
            id = chooseEquation();
        } else {
            id = chooseSystems();
        }
        System.out.println("Программа завершает работу.");
    }
}
