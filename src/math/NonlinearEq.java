package math;

public abstract class NonlinearEq {
    private final int varCount;
    private double a, b;


    public NonlinearEq(int varCount) {
        this.varCount = varCount;
    }

    public int getVarCount() {
        return varCount;
    }

    public double getResult(double[] x) {
        return 0;
    }

    public double getResult(double x) {
        return 0;
    }

    public double extractVar(int varId, double[] x) {
        return getResult(x);
    }

    protected void setLimits(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
