import math.NonlinearEq;
import math.NonlinearSys;

import static math.Solver.solveEq;
import static math.Solver.solveSys;
import static utils.IOUnit.*;
import static utils.Storage.getEqStorage;
import static utils.Storage.getSysStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для лабораторной работы №2!");
        double eps = 0.000001;
        int mode = chooseMode(), id;
        if (mode == 0) {
            id = chooseEq();
            NonlinearEq eq = getEqStorage().get(id - 1);
            solveEq(eq, eps);
        } else {
            id = chooseSys();
            NonlinearSys sys = getSysStorage().get(id - 1);
            double[] x = new double[sys.getVarCount()];
            solveSys(sys, eps, x);
        }
        System.out.println("Программа завершает работу.");
    }
}
