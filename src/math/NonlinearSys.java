package math;

import java.util.ArrayList;

public abstract class NonlinearSys {
    protected final ArrayList<NonlinearEq> eqStorage = new ArrayList<>();

    public int getVarCount() {
        return eqStorage.get(0).getVarCount();
    }

    public ArrayList<NonlinearEq> getEqStorage() {
        return eqStorage;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < eqStorage.size(); i++) {
            if (i != 0) {
                s.append("   ");
            }
            s.append(eqStorage.get(i)).append("\n");
        }
        return s.toString();
    }
}
