package math;

import static utils.IOUnit.printEqSolution;
import static utils.IOUnit.printSysSolution;

public class Solver {
    public static void solveEq(NonlinearEq eq, double eps) {
        double a = eq.getA();
        double b = eq.getB();

        long bisectStartTime = System.nanoTime();
        double bisectX = bisectMethod(a, b, eq, eps);
        long bisectEndTime = System.nanoTime();

        long secantStartTime = System.nanoTime();
        double secantX = secantMethod(a, b, eq, eps);
        long secantEndTime = System.nanoTime();
        printEqSolution(a, b, bisectX, bisectEndTime - bisectStartTime, secantX, secantEndTime - secantStartTime);
    }

    public static void solveSys(NonlinearSys sys, double eps, double[] x) {
        double[] tempX = new double[x.length];
        double[] diff = new double[x.length];

        boolean isSolved;
        int count = 0;
        long startTime = System.nanoTime();
        do {
            count++;
            for (int i = 0; i < x.length; i++) {
                tempX[i] = sys.getEqStorage().get(i).extractVar(i, x);
            }
            isSolved = true;
            for (int i = 0; i < x.length; i++) {
                diff[i] = sys.getEqStorage().get(i).getResult(tempX);
                if (Math.abs(diff[i]) > eps) {
                    isSolved = false;
                }
            }
            System.arraycopy(tempX, 0, x, 0, x.length);
        } while (!isSolved);
        long endTime = System.nanoTime();
        printSysSolution(x, diff, endTime - startTime, count);
    }

    private static double bisectMethod(double a, double b, NonlinearEq eq, double eps) {
        while (b - a > eps) {
            if (eq.getResult(a) * eq.getResult((b + a) / 2) == 0) {
                break;
            } else if (eq.getResult(a) * eq.getResult((b + a) / 2) > 0) {
                a = (b + a) / 2;
            } else {
                b = (b + a) / 2;
            }
        }
        return (b + a) / 2;
    }

    public static double secantMethod (double a, double b, NonlinearEq eq, double eps) {
        double prevX, currX = 0;
        boolean isFirstIter = true;
        do {
            prevX = currX;
            currX = a - (eq.getResult(a) * (b - a)) / (eq.getResult(b) - eq.getResult(a));

            if (eq.getResult(a) * eq.getResult(currX) < 0) {
                b = currX;
            } else if (eq.getResult(currX) * eq.getResult(b) < 0) {
                a = currX;
            } else {
                break;
            }

            if (isFirstIter) {
                isFirstIter = false;
            } else if (Math.abs(currX - prevX) <= eps) {
                break;
            }
        } while (true);
        return currX;
    }
}
