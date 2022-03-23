package math;

public class CalcUnit {
    public static double getFuncResult(byte id, double x) throws IllegalArgumentException {
        switch (id) {
            case 1:
                return Math.pow(x, 3) - 2 * Math.pow(x, 2) - 5 * x + 6;
            case 2:
                return Math.pow(x, 2) - Math.cos(x) + x;
            case 3:
                return Math.pow(Math.E, x - 2 * Math.pow(x, 5)) - 7;
            case 4:
                return x + 1 + Math.log(x - 3);
            case 5:
                return Math.pow(x, 4) + 10 * Math.pow(x, 2) - Math.tan(x);
            default:
                return -1;
        }
    }
}
