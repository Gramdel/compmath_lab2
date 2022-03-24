package utils;

import math.NonlinearEq;
import math.NonlinearSys;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<NonlinearEq> eqStorage = new ArrayList<>();
    private static final ArrayList<NonlinearSys> sysStorage = new ArrayList<>();

    static {
        eqStorage.add(new NonlinearEq(1) {
            {
                setLimits(-1,2);
            }

            @Override
            public double getResult(double x) {
                return Math.pow(x, 3) - 2 * Math.pow(x, 2) - 5 * x + 6;
            }

            @Override
            public String toString() {
                return "x^3-2x^2-5x+6=0";
            }
        });
        eqStorage.add(new NonlinearEq(1) {
            {
                setLimits(-3,3);
            }

            @Override
            public double getResult(double x) {
                return Math.pow(x, 2) - Math.cos(x) + x;
            }

            @Override
            public String toString() {
                return "x^2-cos(x)+x=0";
            }
        });
        eqStorage.add(new NonlinearEq(1) {
            {
                setLimits(-3,3);
            }

            @Override
            public double getResult(double x) {
                return Math.pow(Math.E, x) - 7;
            }

            @Override
            public String toString() {
                return "e^(x)-7=0";
            }
        });
        eqStorage.add(new NonlinearEq(1) {
            {
                setLimits(3.01,6);
            }

            @Override
            public double getResult(double x) {
                return x + 1 + Math.log(x - 3);
            }

            @Override
            public String toString() {
                return "x+1+ln(x-3)=0";
            }
        });
        sysStorage.add(new NonlinearSys() {
            {
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return 2 * x[0] + x[1] - 3;
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 0:
                                return (3 - x[1]) / 2;
                            case 1:
                                return 3 - 2 * x[0];
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "2x+y-3=0";
                    }
                });
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return Math.pow(x[0], 2) + 2 * Math.pow(x[1], 2) - 9;
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 0:
                                return Math.sqrt(9 - 2 * Math.pow(x[1], 2));
                            case 1:
                                return Math.sqrt((9 - Math.pow(x[0], 2)) / 2);
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "x^2+2y^2-9=0";
                    }
                });
            }
        });
        sysStorage.add(new NonlinearSys() {
            {
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return 9 * Math.log10(x[0]) - Math.pow(x[1], 2);
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 0:
                                return Math.pow(10, Math.pow(x[1], 2) / 9);
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "9lg(x)-y^2=0";
                    }
                });
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return 2 * Math.pow(x[0], 3) - 5 * Math.pow(x[1], 2) + 1;
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 1:
                                return Math.sqrt((2 * Math.pow(x[0], 3) + 1) / 5);
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "2x^3-5y^2+1=0";
                    }
                });
            }
        });
        sysStorage.add(new NonlinearSys() {
            {
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return Math.sin(x[1] - 0.6) - x[0] - 1.6;
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 0:
                                return Math.sin(x[1] - 0.6) - 1.6;
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "sin(y-0.6)-x-1.6=0";
                    }
                });
                this.eqStorage.add(new NonlinearEq(2) {
                    @Override
                    public double getResult(double[] x) {
                        return 3 * x[1] - Math.cos(x[0]) - 0.9;
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 1:
                                return (Math.cos(x[0]) + 0.9) / 3;
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "3y-cos(x)-0.9=0";
                    }
                });
            }
        });
        sysStorage.add(new NonlinearSys() {
            {
                this.eqStorage.add(new NonlinearEq(3) {
                    @Override
                    public double getResult(double[] x) {
                        return Math.log10(4 * x[0]) + x[1] - x[2] * Math.sqrt(3);
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 0:
                                return Math.pow(10, x[2] * Math.sqrt(3) - x[1]) / 4;
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "lg(4x)+y-z*sqrt(3)=0";
                    }
                });
                this.eqStorage.add(new NonlinearEq(3) {
                    @Override
                    public double getResult(double[] x) {
                        return Math.pow(x[0], 2) + Math.sin(3 * x[1]) + x[2];
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 1:
                                return Math.asin(-Math.pow(x[0], 2) - x[2]) / 3;
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "x^2+sin(3y)+z=0";
                    }
                });
                this.eqStorage.add(new NonlinearEq(3) {
                    @Override
                    public double getResult(double[] x) {
                        return -0.4 * x[0] + 0.5 * Math.pow(x[1], 2) + 8 * Math.log10(x[2]);
                    }

                    @Override
                    public double extractVar(int varId, double[] x) {
                        switch (varId) {
                            case 2:
                                return Math.pow(10, (0.4 * x[0] - 0.5 * Math.pow(x[1], 2)) / 8);
                            default:
                                return -1;
                        }
                    }

                    @Override
                    public String toString() {
                        return "-0.4x+0.5y^2+8lg(z)=0";
                    }
                });
            }
        });
    }

    public static ArrayList<NonlinearEq> getEqStorage() {
        return eqStorage;
    }

    public static ArrayList<NonlinearSys> getSysStorage() {
        return sysStorage;
    }
}
